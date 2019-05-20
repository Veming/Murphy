/**
 * Copyright (C), 2016-2019, 便利蜂商贸有限公司
 * FileName: AccountRegDTO
 * Author:   hang.su01
 * Date:     2019-05-20 15:56
 * Description:
 * History:
 * <author>          <time>
 * hang.su01         2019-05-20 15:56
 */
package com.cloud.murphy.bean.account;

import lombok.Builder;
import lombok.Data;

/**
 * @author hang.su01
 * @since 2019-05-20 15:56
 */
@Data
@Builder
public class AccountRegDTO extends AccountInfo{
    /**
     * 确认密码
     */
    private String confirmPassword;
}
