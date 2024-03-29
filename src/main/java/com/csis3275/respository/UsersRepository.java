package com.csis3275.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
Users findByUsername(String username);
}
