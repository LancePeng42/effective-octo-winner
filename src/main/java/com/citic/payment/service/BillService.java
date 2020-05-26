package com.citic.payment.service;

import com.citic.payment.core.Service;
import com.citic.payment.model.Bill;
import com.citic.payment.model.BillBean;
import com.citic.payment.model.NewBillBean;

import java.util.List;

/**
 * Created by lance on 2020/05/25.
 */
public interface BillService extends Service<Bill> {

    List<Bill> getArrearsBill();

    List<Bill> getArrearsBillForOneMonth();

    List<Bill> getBillByUserId(Integer id);

    List<BillBean> getFullBillByUserId(Integer id);
    
    List<BillBean> convertBill(List<Bill> billList);

    Boolean add(NewBillBean newBillBean);

    /*
     *input: 待核验的账单
     * output: 核验结果，若应缴费无误，则返回-1
     *                   若应缴费有误，则返回正确的结果
     */
    int checkBill(Bill bill);
}
