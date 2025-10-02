package com.security.spring.service;

import com.security.spring.repository.ApplicationUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ApplicationUsersService Class used to get the userDetails.
 */

@Service
@RequiredArgsConstructor
public class ApplicationUsersService implements UserDetailsService {

    private final ApplicationUsersRepository applicationUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUsersRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not able to find find UserDetails for given UserName " + username));
    }
}
