package com.cloud.murphy.dao;

import com.cloud.murphy.bean.account.AccountBaseInfo;
import com.cloud.murphy.bean.account.AccountInfo;
import com.cloud.murphy.bean.account.AccountSearchParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author hang.su01
 * @since 2019-05-19 21:41
 */
@Repository
public interface AccountInfoDao {
    /**
     * 注册新用户
     * @param accountInfo
     */
    void saveAccountInfo(@Param("item") AccountInfo accountInfo);

    /**
     * 查询用户基础信息
     * 仅限登录时使用
     * @param param
     * @return
     */
    AccountInfo selectAccountInfo(@Param("param") AccountSearchParam param);


    Integer count(@Param("param")AccountSearchParam searchParam);
}
