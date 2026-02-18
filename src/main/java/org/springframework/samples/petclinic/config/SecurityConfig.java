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
				.requestMatchers("/", "/login", "/error", "/css/**", "/webjars/**", "/images/**")
				.permitAll()

				.requestMatchers("/costumer/**")
				.hasRole("OWNER")
					
				.requestMatchers("/vets/**")
				.hasAnyRole("ADMIN", "RECEPTIONIST")

				.requestMatchers("/owners/**")
				.hasAnyRole("ADMIN", "RECEPTIONIST")

				// RECEPTIONIST can access everything except /users/**
				.requestMatchers("/users/**")
				.hasRole("ADMIN")

				.anyRequest()
				.permitAll())

			// Login configuration
			.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/", true).permitAll())

			// Logout configuration
			.logout(logout -> logout
				.logoutSuccessUrl("/")  // <-- redirect to "/" after logout
				.permitAll()
			);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // Only for testing
	}

}
