package com.allen.service.impl;

import com.allen.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("执行了保存方法");
    }
}
