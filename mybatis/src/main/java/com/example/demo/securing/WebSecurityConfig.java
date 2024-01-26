package com.example.demo.securing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()	//permitAll() 아무나 접근 가능
				.antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")	//로그인 페이지 안 만들고 디폴트로 제공하는 로그인 페이지 쓸거니까 일단 막아두기
				.usernameParameter("userid")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			//.userDetailsService(null);	//굳이 이거 안넣어도 impl에서 @Service해주면 알아서...
			;
		return http.build();
	}

	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
