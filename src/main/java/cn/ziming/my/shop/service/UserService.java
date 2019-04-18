package cn.ziming.my.shop.service;

import cn.ziming.my.shop.entity.User;

import java.sql.SQLException;

public interface UserService {
    public User login(String email, String pwd) throws SQLException;
}
