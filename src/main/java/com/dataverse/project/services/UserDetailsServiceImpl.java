package com.dataverse.project.services;

import com.dataverse.project.domains.User;
import com.dataverse.project.models.LoggedUser;
import com.dataverse.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(email);
        }

        LoggedUser loggedUser = new LoggedUser(email, user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ADMIN")));

        loggedUser.setFirstName(user.getFirstName());
        loggedUser.setLastName(user.getLastName());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setPhoneNumber(user.getPhoneNumber());
        loggedUser.setCompanyName(user.getCompanyName());
        loggedUser.setPassword(user.getPassword());

        return loggedUser;

    }
}
