package com.sunshine.domain.enumeration;

/**
 * 响应信息状态的枚举类
 * 1、使用EnumClass.values()，我们所用的常量可以一一列举出来，即枚举。
 * 2、每一个常量可以附带信息和行为，封装性好方便使用。（vital）
 */
public enum StatusEnum {
    /**
     * 响应信息的状态类别，数字表示对应的索引值
     */
    SUCCESS(1, "响应成功"),
    FAILURE(0, "响应失败"),
    UNKNOW_ERROR(-1, "未知错误");

    /**
     * 响应信息的状态码
     */
    private Integer code;
    /**
     * 具体的响应信息
     */
    private String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
