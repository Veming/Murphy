/**
 * Copyright (C), 2016-2019, 便利蜂商贸有限公司
 * FileName: LoginParam
 * Author:   hang.su01
 * Date:     2019-05-20 13:29
 * Description:
 * History:
 * <author>          <time>
 * hang.su01         2019-05-20 13:29
 */
package com.cloud.murphy.bean.account;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hang.su01
 * @since 2019-05-20 13:29
 */
@Data
@Builder
@NoArgsConstructor
public class AccountSearchParam {
    String username;
}
