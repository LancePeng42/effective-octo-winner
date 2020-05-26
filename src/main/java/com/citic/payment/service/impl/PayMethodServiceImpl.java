package com.citic.payment.service.impl;

import com.citic.payment.core.AbstractService;
import com.citic.payment.dao.PayMethodMapper;
import com.citic.payment.model.PayMethod;
import com.citic.payment.service.PayMethodService;
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
public class PayMethodServiceImpl extends AbstractService<PayMethod> implements PayMethodService {
    @Resource
    private PayMethodMapper payMethodMapper;

    @Override
    public List<PayMethod> getPayMethodByUserId(Integer id) {
        Condition condition = new Condition(PayMethod.class);
        condition.createCriteria().andEqualTo("userId",id);
        List<PayMethod> list = payMethodMapper.selectByCondition(condition);
        if (list.size() >= 1) {
            return list;
        }
        return null;
    }
}
