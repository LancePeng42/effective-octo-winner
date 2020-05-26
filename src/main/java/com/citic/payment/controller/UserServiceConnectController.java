package com.citic.payment.controller;
import com.citic.payment.core.Result;
import com.citic.payment.core.ResultGenerator;
import com.citic.payment.model.UserServiceConnect;
import com.citic.payment.service.UserServiceConnectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by lance on 2020/05/25.
*/
@RestController
@RequestMapping("/user/service/connect")
public class UserServiceConnectController {
    @Resource
    private UserServiceConnectService userServiceConnectService;

    @PostMapping("/add")
    public Result add(UserServiceConnect userServiceConnect) {
        userServiceConnectService.save(userServiceConnect);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userServiceConnectService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserServiceConnect userServiceConnect) {
        userServiceConnectService.update(userServiceConnect);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserServiceConnect userServiceConnect = userServiceConnectService.findById(id);
        return ResultGenerator.genSuccessResult(userServiceConnect);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserServiceConnect> list = userServiceConnectService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
