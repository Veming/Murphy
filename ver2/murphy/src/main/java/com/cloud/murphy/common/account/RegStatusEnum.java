package com.cloud.murphy.common.account;

import lombok.Getter;

/**
 * @author hang.su01
 * @since 2019-05-20 16:13
 */
@Getter
public enum RegStatusEnum {
    NO_EXCEPTION(0, "注册成功"),
    CONFIRM_PWD_FAIL(1, "确认密码与密码不相同"),
    USER_NAME_EXIST(2, "用户名已存在"),
    ;

    private Integer id;
    private String cn;

    RegStatusEnum(Integer id, String cn) {
        this.id = id;
        this.cn = cn;
    }
}
