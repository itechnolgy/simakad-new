package com.simakad.cms.auth;
//
//import com.simakad.dao.entity.Users;
//import com.simakad.dao.repo.UserDao;

import com.simakad.cms.model.MyUserDetails;
import com.simakad.dao.entity.UserProfile;
import com.simakad.dao.entity.Users;
import com.simakad.dao.repo.UserDao;
import com.simakad.dao.repo.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
* Created by SRIN on 9/21/2016.
*/
@Component
public class UsersDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserProfileDao userProfileDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findOne(username);
        if( user == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));
        return buildUserForAuth(user, authorities);
    }

    private MyUserDetails buildUserForAuth(Users users, List<GrantedAuthority> authorities) {
//        return new User(users.getUsername(), users.getPassoword(), authorities);
        UserProfile userProfile = userProfileDao.findOne(users.getUserProfileId());
        return new MyUserDetails(users, userProfile, authorities);
    }
}
