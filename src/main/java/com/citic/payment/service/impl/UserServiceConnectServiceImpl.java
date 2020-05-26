package com.citic.payment.service.impl;

import com.citic.payment.dao.UserServiceConnectMapper;
import com.citic.payment.model.UserServiceConnect;
import com.citic.payment.service.UserServiceConnectService;
import com.citic.payment.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lance on 2020/05/25.
 */
@Service
@Transactional
public class UserServiceConnectServiceImpl extends AbstractService<UserServiceConnect> implements UserServiceConnectService {
    @Resource
    private UserServiceConnectMapper userServiceConnectMapper;

}
