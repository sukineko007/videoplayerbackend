package com.video.videoplayerbackend.controller;

import com.video.videoplayerbackend.config.AutowiredConfig;
import com.video.videoplayerbackend.entity.Score;
import com.video.videoplayerbackend.entity.UploadFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : author
 * @date : 2020/5/1 14:55
 * @description : --FileController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("file")
public class FileController extends AutowiredConfig {
    @PostMapping("/upload")
    public Object uploadFile(UploadFile uploadFile) throws Exception{
        MultipartFile multipartFile = uploadFile.getFile();
        String name = uploadFile.getName();
        String suffix = name.substring(name.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid+suffix;
        String path = "D:/image/" + fileName;
        File file = new File(path);
        multipartFile.transferTo(file);
        Map<String, String> map = new HashMap<>();
        map.put("vpath", "http://localhost:8700/image/" + fileName);
        return map;
    }
}
