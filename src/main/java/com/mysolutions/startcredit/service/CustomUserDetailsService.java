package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.User;
import com.mysolutions.startcredit.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    user.isActive(),
                    true,
                    true,
                    true,
                    AuthorityUtils.createAuthorityList(user.getRoles().toString())
            );
        }
        else {
            throw new UsernameNotFoundException("No user with "
                    + "the name " + username + "was found in the database");
        }
    }
}
