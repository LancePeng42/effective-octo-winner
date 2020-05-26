package com.citic.payment.controller;

import com.citic.payment.core.Result;
import com.citic.payment.core.ResultGenerator;
import com.citic.payment.model.Bill;
import com.citic.payment.model.BillBean;
import com.citic.payment.model.NewBillBean;
import com.citic.payment.service.BillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* Created by lance on 2020/05/25.
*/
@RestController
@RequestMapping("/bill")
public class BillController {
    @Resource
    private BillService billService;

    @PostMapping("/add")
    public Result add(@RequestBody NewBillBean newBillBean) {
        if (billService.add(newBillBean)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("新建失败");
        }
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        billService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Bill bill) {
        billService.update(bill);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Bill bill = billService.findById(id);
        return ResultGenerator.genSuccessResult(bill);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Bill> list = billService.findAll();
        List<BillBean> billBeanList = this.billService.convertBill(list);
        PageInfo pageInfo = new PageInfo(billBeanList);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/list/user")
    public Result listByUser(@RequestParam Integer id) {
        PageHelper.startPage(0, 0);
        List<BillBean> list = new ArrayList<>();
        list = billService.getFullBillByUserId(id);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/check")
    public Result check(@RequestBody Bill bill) {
        int reuslt = billService.checkBill(bill);
        if (reuslt == -1) {
            return ResultGenerator.genSuccessResult("核验无误，请正常缴费");
        }else{
            bill.setPrice(reuslt);
            this.billService.update(bill);
            return ResultGenerator.genSuccessResult("已修正缴费金额，请核验");
        }
    }
}
