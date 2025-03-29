package com.yokam.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yokam.userManagement.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

  Users findByUserName(String username);

  Users findByEmail(String email);

}
