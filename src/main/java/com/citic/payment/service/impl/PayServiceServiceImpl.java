package com.citic.payment.service.impl;

import com.citic.payment.dao.PayServiceMapper;
import com.citic.payment.model.PayService;
import com.citic.payment.service.PayServiceService;
import com.citic.payment.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lance on 2020/05/25.
 */
@Service
@Transactional
public class PayServiceServiceImpl extends AbstractService<PayService> implements PayServiceService {
    @Resource
    private PayServiceMapper payServiceMapper;

}
