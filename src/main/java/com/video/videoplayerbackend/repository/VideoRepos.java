package com.video.videoplayerbackend.repository;

import com.video.videoplayerbackend.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:49
 * @description : --VideoRepos类描述--
 */
@Repository
public interface VideoRepos extends JpaRepository<Video, Integer> {

    List<Video> findAllByVnameContaining(String vname);
}
