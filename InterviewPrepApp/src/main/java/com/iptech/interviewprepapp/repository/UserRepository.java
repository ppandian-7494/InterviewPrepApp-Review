package com.iptech.interviewprepapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iptech.interviewprepapp.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
