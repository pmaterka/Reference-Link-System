package com.kirg.referencelinksystem.service;

import com.kirg.referencelinksystem.data.UserRepository;
import com.kirg.referencelinksystem.entity.ApplicationUser;
import com.kirg.referencelinksystem.security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<ApplicationUser> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    public ApplicationUser save(ApplicationUser applicationUser) {
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        return userRepository.save(applicationUser);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}