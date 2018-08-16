package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.model.User;

public interface UserService {
    User getUserById(int id);
    User register(String username,String password);
    User login(String username,String password);
}
