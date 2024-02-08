package com.thandeptrai.FormLoginDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thandeptrai.FormLoginDemo.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
    
    public List<Users> findByUsername(String username);

}
