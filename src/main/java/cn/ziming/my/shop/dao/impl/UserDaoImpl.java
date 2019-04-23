package cn.ziming.my.shop.dao.impl;

import cn.ziming.my.shop.dao.UserDao;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.commons.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User quireUserByUid(User user) {

        logger.debug("调用 quireUserByUid(), email{} pwd{}",user.getEmail(),user.getPwd());

        try {
            String qurireUser = "select * from lg_user where email = ? and pwd = ?";

            Connection coon = DBUtil.getConn();
            PreparedStatement ps = coon.prepareStatement(qurireUser);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPwd());
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    user.setUid(rs.getString("uid"));
                    user.setUname(rs.getString("uname"));
                    user.setEmail(rs.getString("email"));
                    user.setPwd(rs.getString("pwd"));
                    logger.info("成功获取");
                    return user;
                }
            } else {
                logger.info("获取失败");
            }
            rs.close();
            ps.close();
            coon.close();
            return null;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
