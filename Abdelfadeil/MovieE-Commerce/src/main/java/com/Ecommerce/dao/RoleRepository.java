package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {

	public AppRole findByRoleName(String roleName);

}
