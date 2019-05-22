package com.cloud.murphy.biz.account.impl;

import clover.org.apache.commons.lang.StringUtils;
import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountLoginDTO;
import com.cloud.murphy.bean.account.AccountSearchParam;
import com.cloud.murphy.bean.account.ResVO;
import com.cloud.murphy.biz.account.AccountLoginBiz;
import com.cloud.murphy.common.JsonResult;
import com.cloud.murphy.common.account.LoginStatusEnum;
import com.cloud.murphy.service.account.AccountService;
import com.cloud.murphy.util.TokenUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author hang.su01
 * @since 2019-05-20 16:03
 */
@Component
@Log4j2
public class AccountLoginBizImpl implements AccountLoginBiz {
    @Resource
    private AccountService accountService;

    private final String SUCCESS = "登录成功";

    private LoginStatusEnum checkParam(AccountLoginDTO accountLoginDTO) {

        if (StringUtils.isEmpty(accountLoginDTO.getUsername())) {
            return LoginStatusEnum.WITHOUT_USER_NAME;
        }
        if (StringUtils.isEmpty(accountLoginDTO.getPassword())) {
            return LoginStatusEnum.WITHOUT_PASSWORD;
        }

        return LoginStatusEnum.NO_EXCEPTION;
    }

    @Override
    public JsonResult login(AccountLoginDTO accountLoginDTO) {
        ResVO res = new ResVO();
        LoginStatusEnum loginStatus = checkParam(accountLoginDTO);
        if (!loginStatus.equals(LoginStatusEnum.NO_EXCEPTION)) {
            res.setStatus(loginStatus.getId());
            res.setMessage(loginStatus.getCn());
            return JsonResult.success(res);
        }

        // 获取用户名和密码
        AccountSearchParam searchParam = new AccountSearchParam();
        BeanUtils.copyProperties(accountLoginDTO, searchParam);
        AccountInfo accountInfo = accountService.getAccountInfo(searchParam);
        if (Objects.isNull(accountInfo) || !StringUtils.equals(accountInfo.getPassword(), accountLoginDTO.getPassword())) {
            res.setStatus(LoginStatusEnum.LOGIN_FAIL.getId());
            res.setMessage(LoginStatusEnum.LOGIN_FAIL.getCn());
            return JsonResult.success(res);
        }

        // 设置token信息
        String token = accountService.makeToken(accountInfo.getId());
        res.setStatus(0);
        res.setMessage(SUCCESS);
        res.setToken(token);

        return JsonResult.success(res);
    }
}
