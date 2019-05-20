package com.cloud.murphy.common.account;

import lombok.Getter;

/**
 * @author hang.su01
 * @since 2019-05-20 16:13
 */
@Getter
public enum LoginStatusEnum {
    NO_EXCEPTION(0, "校验无异常"),
    LOGIN_FAIL(1, "用户名或密码错误"),
    WITHOUT_USER_NAME(2, "请输入用户名"),
    WITHOUT_PASSWORD(3, "请输入密码"),
    WITHOUT_TOKEN(4, "没有 token 信息"),
    ;

    private Integer id;
    private String cn;

    LoginStatusEnum(Integer id, String cn) {
        this.id = id;
        this.cn = cn;
    }
}
