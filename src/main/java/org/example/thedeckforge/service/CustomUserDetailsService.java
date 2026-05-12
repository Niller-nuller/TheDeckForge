// service/CustomUserDetailsService.java
package org.example.thedeckforge.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JdbcTemplate jdbc;

    public CustomUserDetailsService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        String sql = "SELECT Email, PasswordHash, UserRole FROM Credentials WHERE Email = ?";
        try {
            return jdbc.queryForObject(sql, (rs, rowNum) -> User.builder()
                    .username(rs.getString("Email"))
                    .password(rs.getString("PasswordHash"))
                    .roles(rs.getString("UserRole"))
                    .build(), email);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Bruger ikke fundet: " + email);
        }
    }
}