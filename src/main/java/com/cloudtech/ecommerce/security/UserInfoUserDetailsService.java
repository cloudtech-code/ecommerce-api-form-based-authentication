package com.cloudtech.ecommerce.security;

import com.cloudtech.ecommerce.entity.UserInfo;
import com.cloudtech.ecommerce.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(username);
        return userInfoOptional.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
    }
}
