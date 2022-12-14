package com.zwc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    //文件存储位置
    private final static String FILESSERVER = "http://117.16.136.189:8090/upload/";

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public Map<String, String> fileUpload(MultipartFile headPhoto, HttpServletRequest req) throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();
        // 避免文件名冲突，使用UUID替换文件名
        String uuid = UUID.randomUUID().toString();
        //获取拓展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        if (!extendsName.equals(".jpg")) {
            map.put("message", "must be jpg");
            return map;
        }
        // 新的文件名
        String newFileName = uuid.concat(extendsName);

        //创建sun公司提供的jersey包中的client对象
        Client client = Client.create();
        WebResource resource = client.resource(FILESSERVER + newFileName);
        //文件保存到另一个服务器
        resource.put(String.class, headPhoto.getBytes());

        //上传成功之后，把文件的名字和类型返回给浏览器
        map.put("message", "upload success");
        map.put("newFileName", newFileName);
        String contentType = headPhoto.getContentType();
        map.put("filetype", contentType);

        return map;
    }

    @RequestMapping("fileDownload.do")
    public void fileDownload(String photo, String filetype, HttpServletResponse response) throws Exception {
        //获取要下载的文件名 文件类型

        //设置响应头
        //告诉浏览器要将数据保存到磁盘上，不在浏览器上直接解析
        response.setHeader("Content-Disposition", "attachment;filename=" + photo);
        //告诉浏览器下载的文件类型
        response.setContentType(filetype);
        //获取文件的输入流
        URL url = new URL(FILESSERVER + photo);
        InputStream inputStream = url.openStream();
        //获取一个指向浏览器的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //向浏览器响应文件即可
        IOUtils.copy(inputStream, outputStream);
    }
}
