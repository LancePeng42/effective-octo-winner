package com.citic.payment.controller;

import com.citic.payment.core.Result;
import com.citic.payment.core.ResultGenerator;
import com.citic.payment.model.LoginParam;
import com.citic.payment.model.User;
import com.citic.payment.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by lance on 2020/05/25.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        User user = userService.login(loginParam.getPhone(), loginParam.getPassword());
        if (user != null) {
            return ResultGenerator.genSuccessResult(user);
        } else {
            return ResultGenerator.genFailResult("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        User result = userService.register(user);
        if (result != null) {
            return ResultGenerator.genSuccessResult(result);
        } else {
            return ResultGenerator.genFailResult("注册失败，该用户已存在");
        }
    }
}
