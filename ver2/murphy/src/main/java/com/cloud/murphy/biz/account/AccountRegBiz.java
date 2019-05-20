package com.cloud.murphy.biz.account;

import com.cloud.murphy.bean.account.AccountRegDTO;
import com.cloud.murphy.common.JsonResult;

/**
 * @author hang.su01
 * @since 2019-05-20 15:37
 */
public interface AccountRegBiz {
    /**
     * 注册新用户
     * @param accountRegDTO 注册信息
     * @return 返回状态
     */
    JsonResult reg(AccountRegDTO accountRegDTO);
}
