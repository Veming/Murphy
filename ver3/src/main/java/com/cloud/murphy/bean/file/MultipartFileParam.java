package com.cloud.murphy.bean.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件传输对象
 */
@ApiModel("大文件分片入参实体")
public class MultipartFileParam {
    @ApiModelProperty("文件传输任务ID")
    private String taskId;

    @ApiModelProperty("当前为第几分片")
    private int chunk;

    @ApiModelProperty("每个分块的大小")
    private long size;


    @ApiModelProperty("分片总数")
    private int chunkTotal;

    @ApiModelProperty("主体类型--这个字段是我项目中的其他业务逻辑可以忽略")
    private int objectType;

    @ApiModelProperty("分块文件传输对象")
    private MultipartFile file;

}