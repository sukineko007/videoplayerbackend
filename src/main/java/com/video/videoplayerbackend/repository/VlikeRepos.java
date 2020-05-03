package com.video.videoplayerbackend.repository;

import com.video.videoplayerbackend.entity.Vlike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:50
 * @description : --VlikeRepos类描述--
 */
@Repository
public interface VlikeRepos extends JpaRepository<Vlike, Integer> {
    List<Vlike> findAllByUidAndVtype(Integer uid, String vtype);

    List<Vlike> findAllByVidAndUidAndVtype(Integer vid, Integer uid, String vtype);
}
