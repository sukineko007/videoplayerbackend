package com.video.videoplayerbackend.controller;

import com.video.videoplayerbackend.config.AutowiredConfig;
import com.video.videoplayerbackend.entity.Score;
import com.video.videoplayerbackend.entity.Video;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : author
 * @date : 2020/5/1 14:24
 * @description : --VideoController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("video")
public class VideoController extends AutowiredConfig {
    @GetMapping("/getdata")
    public Object GetAll() {
        Map<String, Object> map = new HashMap<>();
        List<Video> list = videoRepos.findAll();
        try {
            map.put("carouselData", list.subList(0, 3));
        } catch (Exception ignored) {

        }
        map.put("recommendData", list);
        return map;
    }

    @PostMapping("/search")
    public Object Search(Video video) {
        Map<String, Object> map = new HashMap<>();
        List<Video> list = videoRepos.findAllByVnameContaining(video.getVname());
        map.put("recommendData", list);
        return map;
    }

    @PostMapping("/getVideoByID")
    public Object GetByID(Video video) {
        Map<String, Object> map = new HashMap<>();
        Video video1 = videoRepos.findById(video.getId()).get();
        List<Score> list = scoreRepos.findAllByVid(video.getId());
        String vscore = "";
        int scores = 0;
        List<String> sayData = new ArrayList<>();
        for (Score score : list) {
            scores += score.getVscore();
            sayData.add(score.getVsay());
        }
        DecimalFormat df = new DecimalFormat("0.0");
        if(list.size() > 0 && scores >0) {
            vscore = df.format(((float) scores) / list.size());
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", video1.getId());
        map1.put("vname", video1.getVname());
        map1.put("vimage", video1.getVimage());
        map1.put("vpath", video1.getVpath());
        map1.put("vtype", video1.getFiletype());
        map1.put("vscore", vscore);
        map.put("videoData", map1);
        map.put("videoSayData", sayData);
        return map;
    }

    @PostMapping("/delete")
    public void Delete(Video video) {
        videoRepos.deleteById(video.getId());
    }

    @PostMapping("/add")
    public Object Add(Video video) {
        return videoRepos.save(video);
    }
}
