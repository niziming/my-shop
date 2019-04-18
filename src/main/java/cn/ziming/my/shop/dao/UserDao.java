package cn.ziming.my.shop.dao;

import cn.ziming.my.shop.entity.User;

import java.sql.SQLException;

public interface UserDao {

    public User quireUserByUid(User user) throws SQLException;

}
