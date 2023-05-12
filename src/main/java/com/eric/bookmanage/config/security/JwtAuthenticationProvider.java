package com.eric.bookmanage.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.eric.bookmanage.common.exception.BaseException;
import com.eric.bookmanage.common.exception.SystemErrorType;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(username);
        if (userDetails != null) {
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        username, password, userDetails.getAuthorities());
                return authenticationToken;
            }
        }
        throw new BaseException(SystemErrorType.LOGGIN_NAME_OR_PASSWORD_FAILURE);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

}
