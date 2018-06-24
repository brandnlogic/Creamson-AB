package com.bnl.creamson.ptm.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.bnl.creamson.ptm"})
@EnableJpaRepositories(basePackages={"com.bnl.creamson.ptm.repository.jpa"},
							entityManagerFactoryRef = "cremsonEntityManager",
							transactionManagerRef = "cremsonTransactionmanager",
							repositoryImplementationPostfix= "ModelImpl"
)
@EntityScan("com.bnl.creamson.ptm.entity")
@EnableTransactionManagement
public class MvcConfiguration implements WebMvcConfigurer{

	private static final String RULES_PATH = "rules/";
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean(name = "cremsonEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier(value = "cremsonDB") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory =
				new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		additionalProperties.put("hibernate.show_sql", "true");
		additionalProperties.put("hibernate.hbm2ddl.auto", "none");
		//additionalProperties.put("hibernate.default_schema", "cm");
		additionalProperties.put("hibernate.id.new_generator_mappings", "false");
		entityManagerFactory.setJpaProperties(additionalProperties);
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan("com.bnl.creamson.ptm.entity");
		entityManagerFactory.setPersistenceUnitName("derby");
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(additionalProperties);

		return entityManagerFactory;

	}

	@Bean(name = "cremsonTransactionmanager")
	public PlatformTransactionManager getTransactionManager(
			@Qualifier("cremsonEntityManager") EntityManagerFactory derbyEntityManager) {
		return new JpaTransactionManager(derbyEntityManager);

	}
	@Bean
	public KieFileSystem kieFileSystem() throws IOException {
	    KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
	    for (Resource file : getRuleFiles()) {
	        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
	    }        
	    return kieFileSystem;
	}

	private Resource[] getRuleFiles() throws IOException {
	    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	    return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
	}

	@Bean
	public KieContainer kieContainer() throws IOException {
	    final KieRepository kieRepository = getKieServices().getRepository();

	    kieRepository.addKieModule(new KieModule() {
	        public ReleaseId getReleaseId() {
	            return kieRepository.getDefaultReleaseId();
	        }
	    });

	    KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem()); 
	    kieBuilder.buildAll();

	    return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
	}

	private KieServices getKieServices() {
	    return KieServices.Factory.get();
	}

	@Bean
	public KieBase kieBase() throws IOException {
	    return kieContainer().getKieBase();
	}

	@Bean
	public KieSession kieSession() throws IOException {
	    return kieContainer().newKieSession();
	}
	
}
