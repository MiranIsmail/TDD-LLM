package org.springframework.samples.petclinic.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final OwnerRepository ownerRepository;

	public SecurityConfig(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			Owner owner = ownerRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

			// Use authority_level if you have it; otherwise default to USER
			String role = "USER";

			return User.withUsername(owner.getUsername())
				.password("{noop}" + owner.getPassword()) // Use BCrypt in production
				.roles(role)
				.build();
		};
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**")
				.hasRole("ADMIN")
				.requestMatchers("/user/**")
				.hasRole("USER")
				.anyRequest()
				.authenticated())
			.httpBasic(withDefaults())
			.build();
	}

}
