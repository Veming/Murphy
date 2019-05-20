package com.cloud.murphy.biz.account;

import com.cloud.murphy.bean.account.AccountLoginDTO;
import com.cloud.murphy.common.JsonResult;

/**
 * @author hang.su01
 * @since 2019-05-20 16:03
 */
public interface AccountLoginBiz {
    /**
     * 登录方法
     * @param accountLoginDTO
     * @return
     */
    JsonResult login(AccountLoginDTO accountLoginDTO);
}
