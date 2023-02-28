package com.mywebnotebook.notebook.repository;

import com.mywebnotebook.notebook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
