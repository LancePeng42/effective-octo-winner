package com.citic.payment.util;

import com.citic.payment.model.Bill;
import com.citic.payment.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class Notice implements Runnable {
    @Autowired
    BillService billService;

    @PostConstruct
    public void init(){
        //启动线程实例
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Bill> list = new ArrayList<>();
                list = billService.getArrearsBillForOneMonth();
                if (list.isEmpty()) {
                    try {
                        Thread.sleep(86400000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    noticeAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void noticeAll() {
        // TODO: 通知欠费用户
    }
}
