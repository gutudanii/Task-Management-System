package com.taskmanager.Task.Management.System.Security;

import com.taskmanager.Task.Management.System.Service.UserLogin;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    final UserLogin usersLogin;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/tasks/register",
                        "/tasks/register/save",
                        "/tasks/logout-handler",
                        "/tasks/login-page-error",
                        "/tasks/Error").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().permitAll()
                .failureForwardUrl("/tasks/login-page-error")
                .successForwardUrl("/tasks")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/tasks/login")
                .and()
                .logout()
                .logoutUrl("/tasks/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/tasks/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/tasks/logout-handler")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/tasks/access-denied");

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(usersLogin);

        return provider;
    }


}
