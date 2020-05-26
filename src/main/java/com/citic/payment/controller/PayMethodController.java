package com.citic.payment.controller;
import com.citic.payment.core.Result;
import com.citic.payment.core.ResultGenerator;
import com.citic.payment.model.PayMethod;
import com.citic.payment.service.PayMethodService;
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
@RequestMapping("/pay/method")
public class PayMethodController {
    @Resource
    private PayMethodService payMethodService;

    @PostMapping("/add")
    public Result add(PayMethod payMethod) {
        payMethodService.save(payMethod);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        payMethodService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody PayMethod payMethod) {
        payMethodService.update(payMethod);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PayMethod payMethod = payMethodService.findById(id);
        return ResultGenerator.genSuccessResult(payMethod);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PayMethod> list = payMethodService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/list/user")
    public Result listByUser(@RequestParam Integer id) {
        List<PayMethod> list = new ArrayList<>();
        list = payMethodService.getPayMethodByUserId(id);
        return ResultGenerator.genSuccessResult(list);
    }
}
