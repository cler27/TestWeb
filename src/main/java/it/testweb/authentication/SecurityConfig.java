package it.testweb.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
	http.authorizeRequests()
		.antMatchers("/auth/**").authenticated()
		.antMatchers("/", "/public/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/login.xhtml")
		.defaultSuccessUrl("/auth/home.xhtml")
		.failureUrl("/login.xhtml?error=1")
		.permitAll()
		.and()
		.csrf().disable();
    }

    @Autowired
    private ATAuthenticationProvider atAuthenticationProvider;

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
	auth.authenticationProvider(this.atAuthenticationProvider);
    }
}
