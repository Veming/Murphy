package com.cloud.murphy.service.account;

import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountSearchParam;

/**
 * @author hang.su01
 * @since 2019-05-19 23:09
 */
public interface AccountService {
    /**
     * 保存账号信息
     * @param accountInfo
     */
    Integer saveAccountInfo(AccountInfo accountInfo);

    AccountInfo getAccountInfo(AccountSearchParam searchParam);

    /**
     * 根据条件查询账号数量
     * @param searchParam
     * @return
     */
    Integer count(AccountSearchParam searchParam);

    /**
     * 验证token信息
     * @param token
     * @return uid
     */
    String checkToken(String token);

    String makeToken(Integer uid);
}
