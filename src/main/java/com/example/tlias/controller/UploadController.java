package com.example.tlias.controller;

import com.example.tlias.pojo.Result;
import com.example.tlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
   /* @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
        log.info("文件上传: {},{},{}",username,age,image);
        String origin = image.getOriginalFilename();
        int index = origin.lastIndexOf(".");
        String extname = origin.substring(index);
        String newFileName = UUID.randomUUID().toString()+extname;
        log.info("新的·文件名： {}",newFileName);
        image.transferTo(new File("C:\\C\\"+newFileName));
        return Result.success();
    }*/
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url：{}：",url);
        return Result.success(url);
    }
}
