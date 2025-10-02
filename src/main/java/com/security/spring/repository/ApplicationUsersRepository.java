package com.security.spring.repository;

import com.security.spring.entity.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUsersRepository extends JpaRepository<ApplicationUsers, Long> {
    Optional<ApplicationUsers> findByUserName(String username);
}
