package com.codegym.validateform.service;

import com.codegym.validateform.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(User user) {
        // Logic lưu vào database (giả lập)
        System.out.println("Saving user: " + user);
    }
}