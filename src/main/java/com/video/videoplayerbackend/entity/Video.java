package com.video.videoplayerbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vname;
    private String vimage;
    private String vpath;
    private Integer vnum;
    private String filetype;
}
