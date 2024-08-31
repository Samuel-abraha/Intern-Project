//package com.example.BillingSystem.SecurityConfiguration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(withDefaults()) // Enable CORS
//                .csrf(csrf -> csrf.disable()) // Disable CSRF
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/api/Admin/**").hasRole("ADMIN")
//                                .requestMatchers("/api/Customers/add").permitAll()
//                                .requestMatchers("/api/Customers/**").hasAnyRole("CUSTOMER") // Allow both CUSTOMER and ADMIN
//                                 // Allow unauthenticated access to add customer
//                                .anyRequest().permitAll() // Allow other requests without authentication
//                )
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless sessions
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("password"))
//                .roles("ADMIN")
//                .build();
//        UserDetails customer = User.withUsername("customer")
//                .password(passwordEncoder().encode("password"))
//                .roles("CUSTOMER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, customer);
//    }
//}
