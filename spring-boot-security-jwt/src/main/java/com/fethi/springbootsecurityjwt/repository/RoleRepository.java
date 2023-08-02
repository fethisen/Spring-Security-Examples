package com.fethi.springbootsecurityjwt.repository;


import com.fethi.springbootsecurityjwt.models.ERole;
import com.fethi.springbootsecurityjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
