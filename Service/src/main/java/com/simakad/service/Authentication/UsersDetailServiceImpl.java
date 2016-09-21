//package com.simakad.service.Authentication;
////
////import com.simakad.dao.entity.Users;
////import com.simakad.dao.repo.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by SRIN on 9/21/2016.
// */
//@Component
//public class UsersDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userDao.findOne(username);
//
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(user.getRoles()));
//
//        return buildUserForAuth(user, authorities);
//    }
//
//    private User buildUserForAuth(Users users, List<GrantedAuthority> authority) {
//        return  new User(users.getUsername(), users.getPassoword(), authority);
//    }
//}
