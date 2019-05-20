package com.cloud.murphy.biz.account.impl;

import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountLoginDTO;
import com.cloud.murphy.biz.account.AccountLoginBiz;
import com.cloud.murphy.common.account.LoginStatusEnum;
import com.cloud.murphy.service.account.AccountService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hang.su01
 * @since 2019-05-20 16:03
 */
@Component
public class AccountLoginBizImpl implements AccountLoginBiz {
    @Resource
    private AccountService accountService;

    private final String SUCCESS = "登录成功";

    private LoginStatusEnum checkParam(AccountLoginDTO accountLoginDTO) {


//        accountService.getAccountInfo()
        return null;
    }

    @Override
    public String login(AccountLoginDTO accountLoginDTO) {
        return null;
    }
}
