package com.cloud.murphy.service.account.impl;

import com.cloud.murphy.bean.account.AccountBaseInfo;
import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountSearchParam;
import com.cloud.murphy.dao.AccountInfoDao;
import com.cloud.murphy.service.account.AccountService;
import com.cloud.murphy.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hang.su01
 * @since 2019-05-19 23:10
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountInfoDao accountInfoDao;

    @Override
    public void saveAccountInfo(AccountInfo accountInfo) {
        accountInfoDao.saveAccountInfo(accountInfo);
    }

    @Override
    public AccountInfo getAccountInfo(AccountSearchParam searchParam) {
        return accountInfoDao.selectAccountInfo(searchParam);
    }

    @Override
    public Integer count(AccountSearchParam searchParam) {
        return accountInfoDao.count(searchParam);
    }
}
