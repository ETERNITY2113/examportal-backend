package com.example.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examserver.model.Role;



public interface RoleRepository extends JpaRepository<Role, Long>{

}
