/**
 * Copyright (C), 2016-2019, 便利蜂商贸有限公司
 * FileName: FileInfo
 * Author:   hang.su01
 * Date:     2019-05-22 12:05
 * Description:
 * History:
 * <author>          <time>
 * hang.su01         2019-05-22 12:05
 */
package com.cloud.murphy.bean.file;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hang.su01
 * @since 2019-05-22 12:05
 */
@Data
public class FileInfo implements Serializable {
    private Long id;

    private String filename;

    private String identifier;

    private Long totalSize;

    private String type;

    private String location;

}
