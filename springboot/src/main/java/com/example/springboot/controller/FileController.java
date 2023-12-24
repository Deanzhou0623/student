package com.example.springboot.controller;/*
 *ClassName:FileController
 *Description: file upload and download
 *@Author:deanzhou
 *@Date:2023-12-23 14:47
 */

import cn.hutool.core.io.FileUtil;
import com.example.springboot.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${ip}")
    private String ip;

    @Value("${server.port}")
    private String port;
    //用户图片路径
    private static final String ROOT_PATH = System.getProperty("user.dir") + "/files";

    /*
     * 文件上传
     *  */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        //1.获取文件名   aaa.png
        String originalFileName = file.getOriginalFilename();
        //2.添加唯一标识(避免重复)
        long flag = System.currentTimeMillis();
        String fileName = flag + "_" + originalFileName;
        //3. 最终路径
        File finalFile = new File(ROOT_PATH + "/" + fileName);
        //4. 判断是否存在目录
        if (!finalFile.getParentFile().exists()) {
            finalFile.getParentFile().mkdirs();
        }
        //3. 存到磁盘中
        file.transferTo(finalFile);
        //返回文件的url路径
        String url = "http://" + ip + ":" + port + "/files/download?fileName=" + fileName;
        return Result.success(url);

    }

    /*
     * 文件下载
     * */
    @GetMapping("/download")
    public Result download(String fileName, HttpServletResponse response) throws IOException {
        //1. 获取文件在磁盘完整路径
        File file = new File(ROOT_PATH + "/" + fileName);
        //2. 将文件通过服务器端response
        ServletOutputStream os = response.getOutputStream();
        //3. 设置名称header /  ContentType
        response.setHeader("Content-Dispoition", "attachment;filename" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("application/octet-stream");
        //4. 写入response
        os.write(FileUtil.readBytes(file));
        //5. 关闭/缓存
        os.flush();
        os.close();
        return Result.success();
    }
}
