package com.illuminart.geoanalysis.repository;

import com.illuminart.geoanalysis.entity.User;
import com.illuminart.geoanalysis.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findFirstByRole(Role role);
}

