package org.springframework.samples.petclinic.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withUsername("admin").password("{noop}admin123").roles("ADMIN").build();

		UserDetails user = User.withUsername("user").password("{noop}user123").roles("USER").build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**")
				.hasRole("ADMIN")
				.requestMatchers("/user/**")
				.hasAnyRole("USER", "ADMIN")
				.anyRequest()
				.authenticated())
			.httpBasic(withDefaults())
			.build();
	}

}
