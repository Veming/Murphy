package com.cloud.murphy.web;

import com.cloud.murphy.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hang.su01
 * @since 2019-05-19 20:48
 */

@RequestMapping("/file")
@Controller
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

    @RequestMapping("/upload/v1")
    public JsonResult upload(){
        return JsonResult.success("上传成功");
    }

}
