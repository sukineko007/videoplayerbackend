package com.video.videoplayerbackend.controller;

import com.video.videoplayerbackend.config.AutowiredConfig;
import com.video.videoplayerbackend.entity.Score;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : author
 * @date : 2020/5/1 14:49
 * @description : --ScoreController类描述--
 */
@CrossOrigin
@RestController
@RequestMapping("score")
public class ScoreController extends AutowiredConfig {
    @PostMapping("/add")
    public Object Add(Score score){
        return scoreRepos.save(score);
    }
}
