package com.citic.payment.controller;
import com.citic.payment.core.Result;
import com.citic.payment.core.ResultGenerator;
import com.citic.payment.model.PayService;
import com.citic.payment.service.PayServiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by lance on 2020/05/25.
*/
@RestController
@RequestMapping("/pay/service")
public class PayServiceController {
    @Resource
    private PayServiceService payServiceService;

    @PostMapping("/add")
    public Result add(PayService payService) {
        payServiceService.save(payService);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        payServiceService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody PayService payService) {
        payServiceService.update(payService);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PayService payService = payServiceService.findById(id);
        return ResultGenerator.genSuccessResult(payService);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PayService> list = payServiceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
