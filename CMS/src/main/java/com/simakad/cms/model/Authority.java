package com.simakad.cms.model;

import com.simakad.dao.entity.Users;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Set;

/**
 * Created by SRIN on 9/24/2016.
 */
public class Authority implements GrantedAuthority {
    private String roleName;

    public Authority(String roleName) {
        this.roleName = roleName;
    }

    public Authority(Users users) {
        roleName = users.getRoles();
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}
