package me.afua.simpleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {





    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .anyRequest().authenticated()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("password")).authorities("ADMIN")
                .and().withUser("user").password(new BCryptPasswordEncoder().encode("password")).authorities("USER");

    }
}
