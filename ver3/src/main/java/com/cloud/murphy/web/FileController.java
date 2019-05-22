package com.cloud.murphy.web;

import com.cloud.murphy.bean.file.MultipartFileParam;
import com.cloud.murphy.common.JsonResult;
import com.cloud.murphy.common.Status;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hang.su01
 * @since 2019-05-19 20:48
 */

@RequestMapping("/file")
@Controller
@Log4j2
public class FileController {

    @RequestMapping("/receive/v1")
    public JsonResult receive(){
        return JsonResult.success("接收成功");
    }

    @RequestMapping("/share/v1")
    public JsonResult share(){
        return JsonResult.success("接收成功");
    }

    @RequestMapping("/download/v1")
    public JsonResult download(){
        return JsonResult.success("下载成功");
    }


    @ApiOperation("大文件分片上传")
    @RequestMapping("upload/v1")
    public JsonResult upload(MultipartFileParam param, HttpServletResponse response, HttpServletRequest request) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return JsonResult.error(Status.ERROR, "不支持的表单格式");
        }
        log.info("上传文件 start...");
        return null;
    }

}
