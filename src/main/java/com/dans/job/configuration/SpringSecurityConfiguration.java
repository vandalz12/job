package com.dans.job.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize ->
                    authorize.requestMatchers("/positions/**").hasAuthority("SCOPE_positions:read")
                            .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                    oauth2.jwt(Customizer.withDefaults())
//                        oauth2.opaqueToken(Customizer.withDefaults())
                )
                .build();
    }

}
