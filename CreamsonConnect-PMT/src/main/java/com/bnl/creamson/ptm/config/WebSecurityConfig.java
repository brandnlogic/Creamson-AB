package com.bnl.creamson.ptm.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@Order(1000)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final List<String> AUTH_LIST = Arrays.asList(
            "/swagger-resources/**",
            "/swagger-ui.html**",
            "/webjars/**",
            "favicon.ico");
	
	/*@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;*/

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests().anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(swaggerAuthenticationEntryPoint(), new CustomRequestMatcher(AUTH_LIST))
                .and()
                .httpBasic()
              //  .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .csrf().disable();
    }

    @Bean
    public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("Swagger Realm");
        return entryPoint;
    }

    private class CustomRequestMatcher implements RequestMatcher {

        private List<AntPathRequestMatcher> matchers;

        private CustomRequestMatcher(List<String> matchers) {
            this.matchers = matchers.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList());
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            return matchers.stream().anyMatch(a -> a.matches(request));
        }

    }
	
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/v2/api-docs").authenticated()
                .and()
                .httpBasic();

    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser(
        User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
    }
}
