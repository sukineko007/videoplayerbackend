package com.video.videoplayerbackend.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Vlike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer vid;
    private String vtype;
    private java.sql.Timestamp savetime;
}
