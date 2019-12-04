package org.bea.bea.security.services;

import org.bea.bea.model.User;
import org.bea.bea.repository.UserRepository;
import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User user = userRepository.findByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
//
//        return UserPrinciple.build(user);
//    }

        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);



       // return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return UserPrinciple.build(user);
    }
    }
