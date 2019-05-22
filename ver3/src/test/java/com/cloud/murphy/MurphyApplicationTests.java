package com.cloud.murphy;

import com.cloud.murphy.bean.account.AccountRegDTO;
import com.cloud.murphy.biz.account.AccountRegBiz;
import com.cloud.murphy.common.JsonResult;
import com.cloud.murphy.service.account.AccountService;
import com.cloud.murphy.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private FsShell fsShell;

    @Test
    public void contextLoads() {
    }

    @Test
    public void daoTest(){
        AccountRegDTO dto = AccountRegDTO.builder().build();
        dto.setConfirmPassword(MD5Util.md5("ggg"));
        dto.setPassword(MD5Util.md5("ggg"));
        dto.setUsername("xiaogang");

        JsonResult res = accountRegBiz.reg(dto);
        log.info(res.toString());
    }

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("a", "内容为1" , 60*60*24, TimeUnit.SECONDS);
        log.info(stringRedisTemplate.opsForValue().get("b"));

    }

    @Test
    public void testHdfs() throws IOException {
//        fileSystem.mkdirs(new Path("/spring"));
//        for (FileStatus fileStatus : fsShell.lsr("/")) {
//            System.out.println(">" + fileStatus.getPath());
//        }
        System.out.println(fsShell.lsr("/"));

        fsShell.put("/Users/bianlifeng/Desktop/file/learning.txt","/");
        System.out.println(fsShell.lsr("/"));
//        fsShell.get("/Users/bianlifeng/Desktop/","/learning.txt");
        log.info("执行成功");
    }



}
