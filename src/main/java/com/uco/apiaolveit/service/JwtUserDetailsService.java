package com.uco.apiaolveit.service;

import com.uco.apiaolveit.domain.RedPerson;
import com.uco.apiaolveit.repository.redperson.IRedPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IRedPersonRepository iredUserRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RedPerson user = iredUserRepository.findByUsername(username).block();
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public Mono<RedPerson> save(RedPerson redUser) {
        redUser.setPassword(bcryptEncoder.encode(redUser.getPassword()));
        return iredUserRepository.save(redUser);
    }
}

