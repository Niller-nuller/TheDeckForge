package org.example.thedeckforge.validation;   // <-- byt til "config" eller "security", "validation" giver ikke mening

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //This runs all the beans in this class
@EnableWebSecurity //Initializes Spring Security
@EnableMethodSecurity //This should allow us to accept users based on they roles
public class SecurityConfig {

    // === Hierarki: ADMIN > ORGANIZER > MEMBER ===
    @Bean //This sets the role
    public RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.fromHierarchy("""
            ROLE_ADMIN > ROLE_ORGANIZER
            ROLE_ORGANIZER > ROLE_USER
            """);
    }

    // === Sørg for at @PreAuthorize også respekterer hierarkiet ===
    // BEMÆRK: skal være 'static' for at blive bygget tidligt nok
    @Bean
    static MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);
        return handler;
    }

    // === Password-hashing (BCrypt) ===
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // === Sikkerhedsregler for HTTP requests ===
    @Bean // This build the security flow based on given rules (Which end-point are accessible by what role?, When to encode, and when to check role hierarchy)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth


                        // Kun ADMIN
                        .requestMatchers("/admin/**", "/cards/new", "/cards/*/edit").hasRole("ADMIN")

                        // ORGANIZER eller højere
                        .requestMatchers("/events/new", "/events/*/results").hasRole("ORGANIZER")

                        // MEMBER eller højere (alle indloggede)
                        .requestMatchers("/collection/**", "/decks/**", "/trades/**").hasRole("MEMBER")
// Offentligt
                                .requestMatchers("/", "/indux", "/login", "/register", "/css/**", "/js/**", "/images/**","/cards/**").permitAll()

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}