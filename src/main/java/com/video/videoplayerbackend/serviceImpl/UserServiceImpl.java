package com.video.videoplayerbackend.serviceImpl;

import com.video.videoplayerbackend.entity.User;
import com.video.videoplayerbackend.repository.UserRepos;
import com.video.videoplayerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:52
 * @description : --UserServiceImpl类描述--
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepos userRepos;

    @Override
    public List<User> findByLogin(User user) {
        return userRepos.findAllByUsernameAndPasswordAndUsertype(user.getUsername(),user.getPassword(),user.getUsertype());
    }

    @Override
    public List<User> findByName(String username) {
        return userRepos.findAllByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepos.save(user);
    }
}
