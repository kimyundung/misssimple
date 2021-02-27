package com.misssimple.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadUtils {
    public static Map<String, String> fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        // 1.判断接收到的文件是否为空
        // 2.获取项目部署路径(ssm-web在tomcat上的部署路径 需要HttpServletRequest)
        // 3.获取原文件名
        // 4.生成新文件名
        // 5.文件上传
        // 6.响应数据
        if(file==null){
            throw new RuntimeException("空文件");
        }

        String realPath = request.getServletContext().getRealPath("/");
        realPath = realPath.substring(0, realPath.indexOf("mss-web"));

        String originalFilename = file.getOriginalFilename();

        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        String uploadPath = realPath + "upload\\";
        File filePath = new File(uploadPath, newFileName);
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }
        file.transferTo(filePath);

        Map<String,String> map = new HashMap<>();
        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8888/upload/" + newFileName);

        return map;
    }
}
