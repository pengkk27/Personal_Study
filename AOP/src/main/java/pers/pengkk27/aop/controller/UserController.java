package pers.pengkk27.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.pengkk27.aop.repository.entity.User;
import pers.pengkk27.aop.service.UserService;

/**
 * 用户操作请求类
 *
 * @author yuepeng
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "success";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return "success";
    }
}
