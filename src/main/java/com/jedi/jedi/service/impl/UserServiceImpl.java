package com.jedi.jedi.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.User;
import com.jedi.jedi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User getUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (User)((UserDetails)principal);
        } else {
            return null;
        }
    }
}
