package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.springboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
