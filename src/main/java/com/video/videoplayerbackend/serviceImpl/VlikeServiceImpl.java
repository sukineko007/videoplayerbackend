package com.video.videoplayerbackend.serviceImpl;

import com.video.videoplayerbackend.entity.Vlike;
import com.video.videoplayerbackend.repository.VlikeRepos;
import com.video.videoplayerbackend.service.VlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:51
 * @description : --VlikeServiceImpl类描述--
 */

@Service
public class VlikeServiceImpl implements VlikeService {
    @Autowired
    private VlikeRepos vlikeRepos;

    @Override
    public List<Vlike> getLoveData(Integer uid, String vtype) {
        return vlikeRepos.findAllByUidAndVtype(uid, vtype);
    }
}
