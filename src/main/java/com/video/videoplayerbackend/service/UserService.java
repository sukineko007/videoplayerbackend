package com.video.videoplayerbackend.service;

import com.video.videoplayerbackend.entity.User;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:51
 * @description : --UserService类描述--
 */

public interface UserService {
    List<User> findByLogin(User user);
    List<User> findByName(String username);
    User save(User user);
}
