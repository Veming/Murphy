package com.cloud.murphy.bean.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hang.su01
 * @since 2019-05-20 13:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchParam {
    String username;

    String id;
}
