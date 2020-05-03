package com.video.videoplayerbackend.controller;

import com.video.videoplayerbackend.config.AutowiredConfig;
import com.video.videoplayerbackend.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : author
 * @date : 2020/5/1 13:52
 * @description : --LoginController类描述--
 */
@CrossOrigin
@RestController
@RequestMapping("login")
public class LoginController extends AutowiredConfig {
    @PostMapping("/login")
    public Object Login(User user) {
        Map<String, Object> map = new HashMap<>();
        List<User> users = userService.findByLogin(user);
        if(users.size()>0) {
            map.put("state","success");
            map.put("data",users.get(0));
        }else {
            map.put("state","error");
            map.put("data","用户名或密码错误");
        }
        return map;
    }

    @PostMapping("/add")
    public Object AddUser(User user) {
        Map<String, Object> map = new HashMap<>();
        //判读用户名重复
        List<User> users = userService.findByName(user.getUsername());
        if(users.size()>0) {
            map.put("state","error");
            map.put("data", "用户名已存在，请重新输入");
        }else {
            User user1 = userService.save(user);
            map.put("state", "success");
            map.put("data", user1);
        }
        return map;
    }
}
