package com.sy.rest_api_example.config;

import com.sy.rest_api_example.config.security.direct.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        http
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .antMatchers("/s/**").permitAll()
                                .mvcMatchers("/s/api/v1/**").permitAll()
                                .anyRequest().authenticated()
                )

                .formLogin((formLogin) ->
                        formLogin
                                //.loginPage("/login")
                                .permitAll()
                )
                .logout((logout) ->
                        logout
                                .logoutSuccessUrl("/")
                                .permitAll()
                );

        http
                .sessionManagement()
                .maximumSessions(-1) // 최대 허용 가능 세션 수 설정 (-1은 무제한)
                .maxSessionsPreventsLogin(false); // 동시로그인 설정 (default 는 false)

        http
                .httpBasic().and(); // HttpBasic 인증 방식 사용

        /*http
                .csrf().disable();*/

        http.addFilterBefore(filter, CsrfFilter.class)
                .csrf().disable();

    }

    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
                /*.inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER"));*/
                .userDetailsService(customUserDetailsService);
    }
}