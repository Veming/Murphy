package com.cloud.murphy.web;

import com.cloud.murphy.bean.account.AccountLoginDTO;
import com.cloud.murphy.bean.account.AccountRegDTO;
import com.cloud.murphy.biz.account.AccountLoginBiz;
import com.cloud.murphy.biz.account.AccountRegBiz;
import com.cloud.murphy.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author hang.su01
 * @since 2019-05-19 21:09
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private AccountRegBiz accountRegBiz;

    @Resource
    private AccountLoginBiz accountLoginBiz;

    @RequestMapping("/reg/v1")
    public JsonResult reg(@RequestBody AccountRegDTO accountRegDTO){
        return accountRegBiz.reg(accountRegDTO);
    }

    @RequestMapping("/login/v1")
    public JsonResult login(@RequestBody AccountLoginDTO accountLoginDTO){
        return accountLoginBiz.login(accountLoginDTO);
    }

}
