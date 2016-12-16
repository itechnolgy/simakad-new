package com.simakad.dao.repo;

import com.simakad.dao.constant.UserType;
import com.simakad.dao.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SRIN on 9/21/2016.
 */
public interface UserDao extends JpaRepository<Users, String> {
        Users findByEmail(String email);
        List<Users> findByRoles(UserType roles);

}
