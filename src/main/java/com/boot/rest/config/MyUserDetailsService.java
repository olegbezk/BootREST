package com.boot.rest.config;

import com.boot.rest.dao.UserRepository;
import com.boot.rest.model.User;
import com.boot.rest.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Oleg on 26 Jul 2016.
 */

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths =
                userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRole())).collect(Collectors.toSet());

        List<GrantedAuthority> result = new ArrayList<>(setAuths);

        return result;
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                                                                          List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.isEnabled(),
                true, true, true, authorities);
    }

}
