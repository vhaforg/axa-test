package jp.co.axa.apidemo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        //for swagger test should not use csrf protect
        web.ignoring().antMatchers("/swagger/**")
        .antMatchers("/swagger-ui.html")
        .antMatchers("/api/**")
        .antMatchers("/swagger-resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .headers().contentSecurityPolicy("default-src 'self'");//for xss protect
    }
}

