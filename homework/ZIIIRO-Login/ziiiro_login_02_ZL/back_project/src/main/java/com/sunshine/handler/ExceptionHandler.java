package com.sunshine.handler;

import com.sunshine.domain.enumeration.StatusEnum;
import com.sunshine.domain.vo.ResponseObject;
import com.sunshine.exception.ZiiiroException;
import com.sunshine.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 进行异常统一处理的handler回调机制
 *
 * @ControllerAdvice注解作用： 1.全局异常处理
 * 2.全局数据绑定
 * 3.全局数据预处理
 */
@ControllerAdvice
public class ExceptionHandler {
    /**
     * 将异常信息打印在控制台
     */
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     * 当发生异常的时候将错误信息封装成Object对象返回给前台
     *
     * @param e
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseObject handle(Exception e) {
        /** 判断捕获的异常是否是自定义异常类(方便管理异常) **/
        if (e instanceof ZiiiroException) {
            ZiiiroException ziiiroException = (ZiiiroException) e;
            return ResponseUtil.error(ziiiroException.getCode(), ziiiroException.getMessage());
        }
        logger.error("系统异常={}", e);
        return ResponseUtil.error(StatusEnum.UNKNOW_ERROR.getCode(), StatusEnum.UNKNOW_ERROR.getMessage());
    }
}
