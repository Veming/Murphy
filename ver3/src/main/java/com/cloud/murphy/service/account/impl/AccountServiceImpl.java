package com.cloud.murphy.service.account.impl;

import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountSearchParam;
import com.cloud.murphy.common.account.Account;
import com.cloud.murphy.dao.AccountInfoDao;
import com.cloud.murphy.service.account.AccountService;
import com.cloud.murphy.util.TokenUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author hang.su01
 * @since 2019-05-19 23:10
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountInfoDao accountInfoDao;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Integer saveAccountInfo(AccountInfo accountInfo) {
        return accountInfoDao.saveAccountInfo(accountInfo);
    }

    @Override
    public AccountInfo getAccountInfo(AccountSearchParam searchParam) {
        return accountInfoDao.selectAccountInfo(searchParam);
    }

    @Override
    public Integer count(AccountSearchParam searchParam) {
        return accountInfoDao.count(searchParam);
    }

    @Override
    public String checkToken(@NotNull String token) {
        String uid = stringRedisTemplate.opsForValue().get(Account.TOKEN_HEADER + token);
        return uid;
    }

    @Override
    public String makeToken(@NotNull Integer uid) {
        String token = TokenUtil.makeToken();
        stringRedisTemplate.opsForValue().set(Account.TOKEN_HEADER + token, uid.toString());
        return token;
    }
}
