package com.bogdanovpd.spring.webapp.config;

import com.bogdanovpd.spring.webapp.model.UserRoles;
import com.bogdanovpd.spring.webapp.util.UserAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user**").hasAnyAuthority(UserRoles.ROLE_ADMIN.name(), UserRoles.ROLE_USER.name())
                .antMatchers("/admin**").hasAuthority(UserRoles.ROLE_ADMIN.name())
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("login")
                .passwordParameter("pass")
                .successHandler(new UserAuthenticationSuccessHandler())
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
    }
}
