package com.boot.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by Oleg on 26 Jul 2016.
 */

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new MyUserDetailsService());
    }
}
