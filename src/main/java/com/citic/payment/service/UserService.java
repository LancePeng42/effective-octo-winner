package com.citic.payment.service;
import com.citic.payment.model.User;
import com.citic.payment.core.Service;


/**
 * Created by lance on 2020/05/25.
 */
public interface UserService extends Service<User> {

//    String login(String phone, String password);

    User login(String phone, String password);

    User register(User user);

    User checkUser(String phone);
}
