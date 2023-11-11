package br.com.samorvell.vendas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.csrf().disable()
              .authorizeRequests()
              .antMatchers(HttpMethod.GET, "/produto").permitAll()
              .antMatchers(HttpMethod.POST, "/login").permitAll()
                      .anyRequest().permitAll();
    //.anyRequest().authenticated();

      httpSecurity.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
      return httpSecurity.build();
    }

}
