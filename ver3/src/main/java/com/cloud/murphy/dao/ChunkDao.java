/**
 * Copyright (C), 2016-2019, 便利蜂商贸有限公司
 * FileName: ChunkDao
 * Author:   hang.su01
 * Date:     2019-05-22 12:57
 * Description:
 * History:
 * <author>          <time>
 * hang.su01         2019-05-22 12:57
 */
package com.cloud.murphy.dao;

import com.sun.tools.javac.comp.Check;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author hang.su01
 * @since 2019-05-22 12:57
 */
@Repository
public interface ChunkDao {

    public Integer saveChuck(@Param("param") Check check);

}
