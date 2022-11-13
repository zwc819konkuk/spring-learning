package com.zwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public String fileUpload(MultipartFile headPhoto, HttpServletRequest req) throws Exception {
        //指定文件存储目录为我们项目部署环境下的upload目录
        String realPath = req.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();
        // 避免文件名冲突，使用UUID替换文件名
        String uuid = UUID.randomUUID().toString();
        //获取拓展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 新的文件名
        String newFileName = uuid.concat(extendsName);
        //文件存储位置
        File file = new File(dir, newFileName);
        //文件保存
        headPhoto.transferTo(file);

        return "OK";
    }
}
