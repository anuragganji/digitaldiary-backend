package com.major.DigitalDiary.JWT;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsWrapperService implements UserDetailsService {

    private final JwtUserDetailsService jwtUserDetailsService;

    public JwtUserDetailsWrapperService(JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jwtUserDetailsService.loadUserByUsername(username);
    }
}
