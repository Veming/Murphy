package com.cloud.murphy.bean.account;

import lombok.Data;

/**
 * @author hang.su01
 * @since 2019-05-20 16:05
 */
@Data
public class AccountLoginDTO extends AccountBaseInfo{
    private String token;
}
