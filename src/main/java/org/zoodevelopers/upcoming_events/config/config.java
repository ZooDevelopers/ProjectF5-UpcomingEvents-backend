package org.zoodevelopers.upcoming_events.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.zoodevelopers.upcoming_events.services.*;

import java.util.Arrays;

@Configuration
public class config {
    
    @Value("${api-endpoint}")
    String endpoint;

    UserService service;

    public config(UserService service) {
        this.service = service;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //Falta setear el segundo user, darle los minimos privilegios

        http
                .cors(Customizer.withDefaults()) //Corregire esto como Giaco
                .csrf(csrf -> csrf.disable()) 
                .formLogin(form -> form.disable()) 
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout") // localhost:8080/api/v1/logout
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/login").hasAnyRole("ADMIN") //poner los roles seteados
                        .requestMatchers(HttpMethod.POST, endpoint + "/events").hasAnyRole("ADMIN") //Poner los roles correctos
                        .anyRequest().authenticated())
                .userDetailsService(service)
                 .httpBasic(Customizer.withDefaults()) //Investigar lo del http, la clase, BasicAuthenticationEntryPoint
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));
        return http.build();
    }
    

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); 
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*")); 
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    }
