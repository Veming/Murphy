package com.cloud.murphy.biz.account.impl;

import clover.com.google.gson.JsonObject;
import clover.org.apache.commons.lang.RandomStringUtils;
import clover.org.apache.commons.lang.StringUtils;
import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountRegDTO;
import com.cloud.murphy.bean.account.AccountSearchParam;
import com.cloud.murphy.bean.account.ResVO;
import com.cloud.murphy.biz.account.AccountRegBiz;
import com.cloud.murphy.common.JsonResult;
import com.cloud.murphy.common.account.RegStatusEnum;
import com.cloud.murphy.service.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author hang.su01
 * @since 2019-05-20 15:48
 */
@Component
@Slf4j
public class AccountRegBizImpl implements AccountRegBiz {

    @Resource
    private AccountService accountService;

    private final String SUCCESS = "注册成功";

    /**
     * 校验参数
     * @param accountRegDTO
     * @return
     */
    private RegStatusEnum checkParam(AccountRegDTO accountRegDTO) {
        String confirmPwd = accountRegDTO.getConfirmPassword();
        String pwd = accountRegDTO.getPassword();

        // 确认密码和密码不相同时返回
        if (!StringUtils.equals(confirmPwd, pwd)) {
            return RegStatusEnum.CONFIRM_PWD_FAIL;
        }

        // 检测是否存在对应的用户名
        AccountSearchParam searchParam = AccountSearchParam.builder()
                .username(accountRegDTO.getUsername())
                .build();
        Integer nbr = accountService.count(searchParam);
        if (Objects.nonNull(nbr) && nbr > 0) {
            return RegStatusEnum.USER_NAME_EXIST;
        }

        // 没有异常
        return RegStatusEnum.NO_EXCEPTION;
    }


    @Override
    public JsonResult reg(AccountRegDTO accountRegDTO) {
        ResVO res = new ResVO();
        RegStatusEnum regStatus = checkParam(accountRegDTO);
        if (!RegStatusEnum.NO_EXCEPTION.equals(regStatus)){
            res.setMessage(regStatus.getCn());
            res.setStatus(regStatus.getId());
            return JsonResult.success(res);
        }
        // 如果昵称为空，则随机生成一个昵称
        if (Objects.isNull(accountRegDTO.getNickName())) {
            accountRegDTO.setNickName(RandomStringUtils.randomAlphanumeric(10));
        }

        AccountInfo accountInfo = new AccountInfo();
        BeanUtils.copyProperties(accountRegDTO, accountInfo);
        Integer uid = accountService.saveAccountInfo(accountInfo);
        if (Objects.isNull(uid)) {
            return JsonResult.error(-1, "发生未知错误");
        }
        String token = accountService.makeToken(uid);
        res.setStatus(0);
        res.setMessage(SUCCESS);
        res.setToken(token);

        return JsonResult.success(res);
    }
}
