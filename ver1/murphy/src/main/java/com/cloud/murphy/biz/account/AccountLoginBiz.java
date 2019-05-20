package com.cloud.murphy.biz.account;

import com.cloud.murphy.bean.account.AccountLoginDTO;

/**
 * @author hang.su01
 * @since 2019-05-20 16:03
 */
public interface AccountLoginBiz {
    String login(AccountLoginDTO accountLoginDTO);
}
