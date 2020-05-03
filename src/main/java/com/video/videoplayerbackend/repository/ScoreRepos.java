package com.video.videoplayerbackend.repository;

import com.video.videoplayerbackend.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : author
 * @date : 2020/5/1 13:48
 * @description : --ScoreRepos类描述--
 */
@Repository
public interface ScoreRepos extends JpaRepository<Score, Integer> {

    List<Score> findAllByVid(Integer vid);
}
