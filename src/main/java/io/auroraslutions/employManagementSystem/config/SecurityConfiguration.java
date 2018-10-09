package io.auroraslutions.employManagementSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // allow everyone to register an account; /console is just for testing
        http.authorizeRequests().antMatchers("/register", "/console").permitAll();

        // making H2 console working
        http.headers().frameOptions().disable();

    /*
    https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html#when-to-use-csrf-protection
    for non-browser APIs there is no need to use csrf protection
    */
        http.csrf().disable();

        /*
        // Note:
        // Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
        // Note that the CSRf token is disabled for all requests
        log.info("Disabling CSRF, enabling basic authentication...");
        http
        .authorizeRequests()
            .antMatchers("/**").authenticated() // These urls are allowed by any authenticated user
        .and()
            .httpBasic();
        http.csrf().disable();
         */
    }
}
