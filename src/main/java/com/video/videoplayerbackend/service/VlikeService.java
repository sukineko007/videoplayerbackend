package com.video.videoplayerbackend.service;

import com.video.videoplayerbackend.entity.Vlike;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:51
 * @description : --VlikeService类描述--
 */

public interface VlikeService {
    List<Vlike> getLoveData(Integer uid, String vtype);
}
