package com.security.spring.service;

import com.security.spring.entity.ApplicationUsers;
import com.security.spring.repository.ApplicationUsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createAdminUser(ApplicationUsersRepository applicationUsersRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (applicationUsersRepository.findByUserName("admin").isEmpty()) {
                ApplicationUsers applicationUsers = ApplicationUsers.builder()
                        .userName("admin")
                        .password(passwordEncoder.encode("admin"))
                        .role("RoleAdmin")
                        .build();
                applicationUsersRepository.save(applicationUsers);
                log.info("Admin User added");
            }
        };
    }


}
