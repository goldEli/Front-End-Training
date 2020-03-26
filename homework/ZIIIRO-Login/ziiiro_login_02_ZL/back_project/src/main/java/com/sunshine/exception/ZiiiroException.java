package com.sunshine.exception;

import com.sunshine.domain.enumeration.StatusEnum;

/**
 * 自定义异常类
 * 继承RuntimeException，在程序发生异常时可以触发事务回滚；
 * 继承Exception，在程序发生异常时不会触发事务回滚；
 */
public class ZiiiroException extends RuntimeException {
    // 异常信息的状态码
    private Integer code;

    public ZiiiroException(StatusEnum statusEnum) {
        // RuntimeException的构造方法本身就会传一个msg
        super(statusEnum.getMessage());
        this.code = statusEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
