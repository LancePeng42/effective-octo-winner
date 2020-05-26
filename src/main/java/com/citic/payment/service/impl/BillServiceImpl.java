package com.citic.payment.service.impl;

import com.citic.payment.core.AbstractService;
import com.citic.payment.dao.BillMapper;
import com.citic.payment.model.*;
import com.citic.payment.service.BillService;
import com.citic.payment.service.PayMethodService;
import com.citic.payment.service.PayServiceService;
import com.citic.payment.service.UserService;
import com.citic.payment.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lance on 2020/05/25.
 */
@Service
@Transactional
public class BillServiceImpl extends AbstractService<Bill> implements BillService {
    @Resource
    private BillMapper billMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private PayServiceService payService;
    @Autowired
    private PayMethodService payMethodService;

    @Override
    public List<Bill> getArrearsBill() {
        List<Bill> list = new ArrayList<>();
        Condition condition = new Condition(Bill.class);
        condition.createCriteria().andEqualTo("pay_status", 0);
        list = billMapper.selectByCondition(condition);
        return list;
    }

    @Override
    public List<Bill> getArrearsBillForOneMonth() {
        List<Bill> list = new ArrayList<>();
        list = getArrearsBill();
        List<Bill> arrearsListForOneMonth = new ArrayList<>();
        int currentMonth = DateUtil.getCurrentMonth();
        String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//@date
        for (int i = 0; i < list.size(); i++) {
            if (currentMonth - DateUtil.getMonth(list.get(i).getCreateTime()) >= 1) {
                arrearsListForOneMonth.add(list.get(i));
            }
        }
        return arrearsListForOneMonth;
    }

    @Override
    public List<Bill> getBillByUserId(Integer id) {
        Condition condition = new Condition(Bill.class);
        condition.createCriteria().andEqualTo("userId",id);
        List<Bill> list = billMapper.selectByCondition(condition);
        if (list.size() >= 1) {
            return list;
        }
        return null;
    }

    @Override
    public List<BillBean> getFullBillByUserId(Integer id) {
        List<Bill> billList = new ArrayList<>();
        billList = this.getBillByUserId(id);
        List<BillBean> billBeanList = new ArrayList<>();
        billBeanList = this.convertBill(billList);
        return billBeanList;
    }

    @Override
    public List<BillBean> convertBill(List<Bill> billList) {
        List<BillBean> billBeanList = new ArrayList<>();
        for (int i = 0; i < billList.size(); i++) {
            User user = this.userService.findById(billList.get(i).getUserId());
            PayMethod payMethod = this.payMethodService.findById(billList.get(i).getPayId());
            PayService payService = this.payService.findById(billList.get(i).getServiceId());
            BillBean billBean = new BillBean();
            BeanUtils.copyProperties(billList.get(i), billBean);
            billBean.setUserName(user.getName());
            billBean.setAddr(user.getAddr());
            billBean.setPhone(user.getPhone());
            billBean.setServiceName(payService.getName());
            billBean.setUnitName(payService.getUnitName());
            billBean.setUnitPrice(payService.getUnitPrice());
            billBean.setPayMethodName(payMethod.getBankName());
            billBeanList.add(billBean);
        }
        return billBeanList;
    }

    @Override
    public Boolean add(NewBillBean newBillBean) {
        Bill bill = new Bill();
        String phone = newBillBean.getPhone();
        Condition condition = new Condition(User.class);
        condition.createCriteria().andEqualTo("phone",phone);
        User user = userService.findByCondition(condition).get(0);
        bill.setUserId(user.getId());

        String serviceName = newBillBean.getServiceName();
        Condition conditionPayService = new Condition(PayService.class);
        conditionPayService.createCriteria().andEqualTo("name",serviceName);
        PayService payServiceModel = payService.findByCondition(conditionPayService).get(0);
        bill.setServiceId(payServiceModel.getId());
        bill.setUsed(newBillBean.getUsed());
        bill.setPrice(newBillBean.getUsed()*payServiceModel.getUnitPrice());

        Condition conditionPayMethod = new Condition(PayMethod.class);
        conditionPayMethod.createCriteria().andEqualTo("userId",user.getId());
        PayMethod payMethod = payMethodService.findByCondition(conditionPayMethod).get(0);
        bill.setPayId(payMethod.getId());
        bill.setPayStatus(0);
        int result = billMapper.insert(bill);

        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int checkBill(Bill bill) {
        PayService payServiceModel = this.payService.findById(bill.getServiceId());
        if (payServiceModel.getUnitPrice() * bill.getUsed() == bill.getPrice()) {
            return -1;
        } else {
            return payServiceModel.getUnitPrice() * bill.getUsed();
        }
    }

}
