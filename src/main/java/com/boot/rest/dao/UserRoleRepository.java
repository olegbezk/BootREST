package com.boot.rest.dao;

import com.boot.rest.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oleg on 26 Jul 2016.
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
