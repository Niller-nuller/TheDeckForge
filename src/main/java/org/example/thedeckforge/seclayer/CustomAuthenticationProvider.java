package org.example.thedeckforge.seclayer;

import org.example.thedeckforge.entity.Authority;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Authority userAuthortiy =
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
