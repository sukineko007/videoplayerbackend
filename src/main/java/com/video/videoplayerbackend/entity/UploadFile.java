package com.video.videoplayerbackend.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : author
 * @date : 2020/5/1 14:57
 * @description : --UploadFile类描述--
 */
@Data
public class UploadFile {
    private String name;
    private String filetype;
    private MultipartFile file;
}
