package com.cloud.murphy.common.auth;

import com.cloud.murphy.common.JsonResult;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
@Aspect
@Log4j2
public class AuthHelper {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private String TOKEN_HEADER = "token:";

    @Pointcut("within(com.cloud.murphy.web.*)&&!within(com.cloud.murphy.web.UserController)")
    public void login() {
    }

    @Around("login()")
    public Object auth(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取session中的用户信息
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String uid = stringRedisTemplate.opsForValue().get(TOKEN_HEADER + token);

        if (Objects.isNull(uid)) {
            log.info("用户未登录");
            return JsonResult.error(403, "没有访问权限，请重新登录");
        }

        return joinPoint.proceed();
    }
}
