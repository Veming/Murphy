/**
 * Copyright (C), 2016-2019, 便利蜂商贸有限公司
 * FileName: Chunk
 * Author:   hang.su01
 * Date:     2019-05-22 12:06
 * Description:
 * History:
 * <author>          <time>
 * hang.su01         2019-05-22 12:06
 */
package com.cloud.murphy.bean.file;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hang.su01
 * @since 2019-05-22 12:06
 */
@Data
public class Chunk {

    private Long id;
    /**
     * 当前文件块，从1开始
     */
    private Integer chunkNumber;
    /**
     * 分块大小
     */
    private Long chunkSize;
    /**
     * 当前分块大小
     */
    private Long currentChunkSize;
    /**
     * 总大小
     */
    private Long totalSize;
    /**
     * 文件标识
     */
    private String identifier;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 相对路径
     */
    private String relativePath;
    /**
     * 总块数
     */
    private Integer totalChunks;
    /**
     * 文件类型
     */
    private String type;

    @Transient
    private MultipartFile file;
}
