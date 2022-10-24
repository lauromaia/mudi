package br.com.alura.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		
		
		.authorizeRequests().antMatchers("/home/**").permitAll()
		.anyRequest().
		authenticated().and().formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/usuario/pedido", true)
				.permitAll()
			).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/home"))
			
		.csrf().disable();
		return http.build();
	}
	

	
	@Bean
	UserDetailsManager users(DataSource dataSource) {
		PasswordEncoder passwordEncoder =
			    PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	
	UserDetails user =
			User.builder()
			.username("lauto")
			.password(passwordEncoder.encode("root"))
			.roles("ADM")
			.build();
	JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//	users.createUser(user);
	
	return users;
		
	
	
	}
	
}
