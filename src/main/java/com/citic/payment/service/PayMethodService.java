package com.citic.payment.service;

import com.citic.payment.core.Service;
import com.citic.payment.model.PayMethod;

import java.util.List;

/**
 * Created by lance on 2020/05/25.
 */
public interface PayMethodService extends Service<PayMethod> {

    List<PayMethod> getPayMethodByUserId(Integer id);
}
