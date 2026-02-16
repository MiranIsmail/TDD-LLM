package org.springframework.samples.petclinic.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

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

	private final UserRepository userRepository;

	public SecurityConfig(OwnerRepository ownerRepository, UserRepository userRepository) {
		this.ownerRepository = ownerRepository;
		this.userRepository = userRepository;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			// Try to find owner first
			return ownerRepository.findByUsername(username).map(owner -> {
				String role = owner.getAuthorityLevel() != null ? owner.getAuthorityLevel() : "USER";
				return User.withUsername(owner.getUsername())
					.password("{noop}" + owner.getPassword())
					.roles(role)
					.build();
			})
				// If not found in owners, check the User table
				.orElseGet(() -> userRepository.findByUsername(username).map(user -> {
					String role = user.getAuthorityLevel() != null ? user.getAuthorityLevel() : "USER";
					return User.withUsername(user.getUsername())
						.password("{noop}" + user.getPassword())
						.roles(role)
						.build();
				}).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username)));
		};
	}

	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
		return (request, response, authentication) -> {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			if (roles.contains("ROLE_ADMIN")) {
				response.sendRedirect("/");
			}
			else {
				// Owners or normal users go to /user
				response.sendRedirect("/user");
			}
		};
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				// Only ADMIN can access everything else
				.requestMatchers("/user/**")
				.hasAnyRole("USER", "ADMIN") // Users pages
				.anyRequest()
				.hasRole("ADMIN") // Everything else
			)
			.formLogin(form -> form.successHandler(myAuthenticationSuccessHandler())
				.permitAll())
			.httpBasic(withDefaults())
			.build();
	}

}
