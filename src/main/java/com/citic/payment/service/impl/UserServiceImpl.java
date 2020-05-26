package com.citic.payment.service.impl;

import com.citic.payment.core.AbstractService;
import com.citic.payment.dao.UserMapper;
import com.citic.payment.model.User;
import com.citic.payment.service.UserService;
import com.citic.payment.util.HashUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lance on 2020/05/25.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String phone, String password) {
        Condition condition = new Condition(User.class);
        condition.createCriteria().andEqualTo("phone",phone).andEqualTo("password", HashUtils.encryPassword(password));
        List<User> list = userMapper.selectByCondition(condition);
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User register(User user) {
        //查询是否有相同用户名的用户
        User userCheck = checkUser(user.getPhone());
        if (userCheck==null){
            //将密码进行加密操作
            user.setPassword(HashUtils.encryPassword(user.getPassword()));
            user.setRoleCode(0);
            userMapper.insert(user);
            return user;
        }else{
            return null;
        }
    }

    @Override
    public User checkUser(String phone) {
        Condition condition = new Condition(User.class);
        condition.createCriteria().andEqualTo("phone",phone);
        List<User> list = userMapper.selectByCondition(condition);
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }

}
