package com.Gymnase.services;

import java.util.Collection;
import java.util.stream.Stream;

import com.Gymnase.entities.Roles;

public interface RoleService {
    
    Roles findByRoleName(String roleName);
    
    Collection<Roles> getAllRoles();
    
    Stream<Roles> getAllRolesStream();
}

