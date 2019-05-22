package com.cloud.murphy.bean.account;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hang.su01
 * @since 2019-05-20 16:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountLoginDTO extends AccountBaseInfo{
    private String token;
}
