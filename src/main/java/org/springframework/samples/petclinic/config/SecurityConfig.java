package org.springframework.samples.petclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// 🔥 Disable CSRF for testing (remove in production)
			.csrf(csrf -> csrf.disable())

			// Role-based access rules
			.authorizeHttpRequests(auth -> auth
				// Public pages
				.requestMatchers("/login", "/error")
				.permitAll()

				// Only USER role can access owners
				.requestMatchers("/owners/**")
				.hasRole("USER")

				// RECEPTIONIST can access everything except /users/**
				.requestMatchers("/users/**")
				.hasRole("ADMIN")

				// Admin can access everything else
				.anyRequest()
				.hasAnyRole("ADMIN", "RECEPTIONIST"))

			// Login configuration
			.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/", true).permitAll())

			// Logout configuration
			.logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // Only for testing
	}

}
