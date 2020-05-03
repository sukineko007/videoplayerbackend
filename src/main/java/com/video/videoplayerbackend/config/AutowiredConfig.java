package com.video.videoplayerbackend.config;

import com.video.videoplayerbackend.repository.ScoreRepos;
import com.video.videoplayerbackend.repository.UserRepos;
import com.video.videoplayerbackend.repository.VideoRepos;
import com.video.videoplayerbackend.repository.VlikeRepos;
import com.video.videoplayerbackend.service.ScoreService;
import com.video.videoplayerbackend.service.UserService;
import com.video.videoplayerbackend.service.VideoService;
import com.video.videoplayerbackend.service.VlikeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : author
 * @date : 2020/5/1 14:00
 * @description : --AutowiredConfig类描述--
 */

public class AutowiredConfig {
    @Autowired
    public UserService userService;
    @Autowired
    public ScoreService scoreService;
    @Autowired
    public VideoService videoService;
    @Autowired
    public VlikeService vlikeService;
    @Autowired
    public ScoreRepos scoreRepos;
    @Autowired
    public UserRepos userRepos;
    @Autowired
    public VideoRepos videoRepos;
    @Autowired
    public VlikeRepos vlikeRepos;
}
