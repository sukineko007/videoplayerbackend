package com.video.videoplayerbackend.controller;

import com.video.videoplayerbackend.config.AutowiredConfig;
import com.video.videoplayerbackend.entity.Video;
import com.video.videoplayerbackend.entity.Vlike;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : author
 * @date : 2020/5/1 14:13
 * @description : --VlikeController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("vlike")
public class VlikeController extends AutowiredConfig {
    @PostMapping("/getLove")
    public Object GetLove(Vlike vlike) {
        List<Vlike> vlikes = vlikeService.getLoveData(vlike.getUid(), vlike.getVtype());
        List<Object> list = new ArrayList<>();
        for(Vlike v : vlikes) {
            Video video = videoRepos.findById(v.getVid()).get();
            Map<String, Object> map = new HashMap<>();
            map.put("id",v.getId());
            map.put("vid",v.getVid());
            map.put("uid",v.getUid());
            map.put("vtype",v.getVtype());
            map.put("vimage",video.getVimage());
            map.put("vname",video.getVname());
            list.add(map);
        }
        return list;
    }

    @PostMapping("/delete")
    public void Delete(Vlike vlike) {
        vlikeRepos.deleteById(vlike.getId());
    }

    @PostMapping("/add")
    public Object Add(Vlike vlike) {
        List<Vlike> list = vlikeRepos.findAllByVidAndUidAndVtype(vlike.getVid(),vlike.getUid(),vlike.getVtype());
        if(list.size() > 0) {
            return null;
        }
        return vlikeRepos.save(vlike);
    }
}
