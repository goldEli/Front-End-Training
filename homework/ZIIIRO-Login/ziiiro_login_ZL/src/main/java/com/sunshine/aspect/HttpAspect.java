package com.sunshine.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 对指定的http请求建立切面，进行逻辑判断
 *
 * @Component:将类讲给IOC容器管理
 */
@Aspect
@Component
public class HttpAspect {
    /**
     * org.slf4j.Logger是spring自带的日志管理工具
     */
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 要使用所定义的Pointcut时，可以指定Pointcut签名（有利于代码的重复利用）
     *
     * @Pointcut：pointcut表达式 log()：pointcut签名
     */
    @Pointcut("execution(public * com.sunshine.web.UserController.login(..))")
    public void log() {
    }

    /**
     * 在请求方法前执行
     * 对所有关于用户的操作，建立切面（判断用户是否处于登录状态）
     * .. 表示输入的任意参数
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("类方法={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //params
        logger.info("方法参数={}", joinPoint.getArgs());
    }

    /**
     * 在请求方法后执行
     */
    @After("log()")
    public void doAfter() {
        logger.info("2222222222222");
    }

    /**
     * 返回响应的对象信息
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturn(Object object) {
        logger.info("return={}", object);
    }
}
