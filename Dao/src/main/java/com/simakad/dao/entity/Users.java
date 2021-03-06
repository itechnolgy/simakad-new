package com.simakad.dao.entity;

import com.simakad.dao.constant.UserType;

import javax.persistence.*;

/**
 * Created by SRIN on 9/21/2016.
 */
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String passoword;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private UserType roles;

    @Column(name = "user_profile_id")
    private Long userProfileId;

    @Transient
    private String decryptPass;

    @Column(name = "email")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public UserType getRoles() {
        return roles;
    }

    public void setRoles(UserType roles) {
        this.roles = roles;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getDecryptPass() {
        return decryptPass;
    }

    public void setDecryptPass(String decryptPass) {
        this.decryptPass = decryptPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
