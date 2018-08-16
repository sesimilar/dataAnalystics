package com.citi.shanghai.training.dataAnalyst.service.impl;

import com.citi.shanghai.training.dataAnalyst.dao.UserMapper;
import com.citi.shanghai.training.dataAnalyst.model.User;
import com.citi.shanghai.training.dataAnalyst.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(new Integer(userId));
    }
    @Override
    public User register(String username, String password) {
        User user = null;
        if(this.userMapper.register(username,password) == 1){
            user = userMapper.login(username,password);
        }
        return user;

    }

    @Override
    public User login(String username,String password) {
        return this.userMapper.login(username,password);

    }
}
