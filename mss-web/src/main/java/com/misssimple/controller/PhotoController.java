package com.misssimple.controller;

import com.misssimple.domain.Meta;
import com.misssimple.domain.ResponseResult;
import com.misssimple.service.PhotoService;
import com.misssimple.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @RequestMapping("/photoUpload")
    public ResponseResult photoUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> map = UploadUtils.fileUpload(file, request);
        ResponseResult result = new ResponseResult();
        result.setData(map);
        result.setMeta(new Meta(201,"图片上传成功"));
        return result;
    }
}
