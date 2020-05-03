package com.video.videoplayerbackend.repository;

import com.video.videoplayerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:49
 * @description : --UserRepos类描述--
 */
@Repository
public interface UserRepos extends JpaRepository<User, Integer> {
    List<User> findAllByUsernameAndPasswordAndUsertype(String username, String password, String usertype);

    List<User> findAllByUsername(String usernaem);
}
