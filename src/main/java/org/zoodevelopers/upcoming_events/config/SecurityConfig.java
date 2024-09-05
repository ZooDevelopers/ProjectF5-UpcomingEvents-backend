package org.zoodevelopers.upcoming_events.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.zoodevelopers.upcoming_events.services.UserService;
import java.time.Duration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("/api/v1")
    String endpoint;

    UserService service;

    MyBasicAuthenticationEntryPoint myBasicAuthenticationEntryPoint;

    public SecurityConfig(UserService service, MyBasicAuthenticationEntryPoint basicEntryPoint) {
        this.service = service;
        this.myBasicAuthenticationEntryPoint = basicEntryPoint;
    }

    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.configurationSource(corsConfiguration()))
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.disable())
        .logout(out -> out
            .logoutUrl(endpoint + "/logout")
            .deleteCookies("JSESSIONID"))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.GET, "api/v1/events", "/api/v1/events/featured").permitAll()
            .requestMatchers(HttpMethod.GET, endpoint + "/login").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, endpoint + "/events").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, endpoint + "/events").hasRole("ADMIN")
            .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
            .requestMatchers(HttpMethod.POST, endpoint + "/register").permitAll()
            .requestMatchers(HttpMethod.POST, endpoint + "/event-registrations/{eventId}/register").authenticated()
            .requestMatchers(HttpMethod.POST, endpoint + "/event-registrations/{eventId}/cancel").authenticated()
            .requestMatchers(HttpMethod.GET, endpoint + "/event-registrations/user/{userId}/registered").authenticated()
            .anyRequest().authenticated())
        .userDetailsService(service)
        .httpBasic(basic -> basic.authenticationEntryPoint(myBasicAuthenticationEntryPoint))
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

    http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

    return http.build();
}


    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true); // Permite el envío de cookies y credenciales
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // El origen del frontend
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos HTTP permitidos
        configuration.setAllowedHeaders(Arrays.asList("*")); // Permite todos los encabezados
        configuration.setMaxAge(Duration.ofHours(1)); // Cacheo de respuestas CORS por 1 hora
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica la configuración a todos los endpoints
        return source;
    }
    
}
