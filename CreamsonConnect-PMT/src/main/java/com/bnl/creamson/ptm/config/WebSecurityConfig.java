package com.bnl.creamson.ptm.config;

import java.util.Arrays;
import java.util.List;

//@Configuration
//@EnableWebSecurity
//@Order(1000)
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
	private static final List<String> AUTH_LIST = Arrays.asList(
            "/swagger-resources/**",
            "/swagger-ui.html**",
            "/webjars/**",
            "favicon.ico",
            "/MeetingApplication/**");
	
	/*@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;*/

	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    .authorizeRequests()
	        .antMatchers("/**").permitAll();
	}*/
	
   /* @Bean
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

    }*/
	
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/v2/api-docs").authenticated()
                .and()
                .httpBasic();

    }*/

    
}
