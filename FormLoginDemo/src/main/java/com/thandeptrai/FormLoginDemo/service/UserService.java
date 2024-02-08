package com.thandeptrai.FormLoginDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thandeptrai.FormLoginDemo.model.Users;
import com.thandeptrai.FormLoginDemo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> newUsers = userRepository.findByUsername(username);
        String password = null;
        List<GrantedAuthority> authorities = null;

        username = newUsers.get(0).getUsername();
        password = newUsers.get(0).getPassword();
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(newUsers.get(0).getRoles()));

        return new User(username, password, authorities);
    }

    public void saveUser(Users users){
        String newpassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(newpassword);
        userRepository.save(users);
    }
    
}
