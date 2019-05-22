package com.cloud.murphy.bean.file;

import lombok.Builder;
import lombok.Data;

/**
 * @author hang.su01
 * @since 2019-05-20 13:24
 */
@Data
@Builder
public class FileBaseInfo {
    private Integer id;

    private String fileName;

    private String fileSize;

    private String md5;
}
