package com.cloud.murphy.bean.account;

import lombok.*;

/**
 * @author hang.su01
 * @since 2019-05-20 15:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountInfo extends AccountBaseInfo {
    private String nickName;

}
