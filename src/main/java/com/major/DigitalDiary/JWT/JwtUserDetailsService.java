package com.major.DigitalDiary.JWT;

import com.major.DigitalDiary.Model.UserCreds;
import com.major.DigitalDiary.Service.UserCredService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {


    private final UserCredService userCredService;


    public JwtUserDetailsService(UserCredService userCredService) {
        this.userCredService = userCredService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCreds userCreds = userCredService.findUserCredsByUsername(username);
        System.out.println("Reached load user");
        System.out.println(userCreds);
        if (userCreds == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        System.out.println(userCreds.getUser().getUsername());
        UserDetails jwtUserDetails = new JwtUserDetails(userCreds.getUser().getUsername(), userCreds.getPassword(), "USER");
        System.out.println(jwtUserDetails);
        UserDetails user = User.withUsername(userCreds.getUser().getUsername())
                .password("{noop}" + userCreds.getPassword())
                .authorities("read")
                .roles("USER")
                .build();
        return user;
    }
}
