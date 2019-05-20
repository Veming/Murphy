package com.cloud.murphy;

import com.cloud.murphy.bean.account.AccountRegDTO;
import com.cloud.murphy.biz.account.AccountRegBiz;
import com.cloud.murphy.service.account.AccountService;
import com.cloud.murphy.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MurphyApplicationTests {

    @Resource
    private AccountService accountService;

    @Resource
    private AccountRegBiz accountRegBiz;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void daoTest(){
        AccountRegDTO dto = AccountRegDTO.builder().build();
        dto.setConfirmPassword(MD5Util.md5("ggg"));
        dto.setPassword(MD5Util.md5("ggg"));
        dto.setUsername("xiaogang");

        String res = accountRegBiz.reg(dto);
        log.info(res);
    }

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("a", "内容为1");
        log.info(stringRedisTemplate.opsForValue().get("a"));



    }
}
