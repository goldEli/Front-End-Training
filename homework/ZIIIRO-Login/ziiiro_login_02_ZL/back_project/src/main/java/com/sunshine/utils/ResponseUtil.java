package com.sunshine.utils;

import com.sunshine.domain.enumeration.StatusEnum;
import com.sunshine.domain.vo.ResponseObject;

/**
 * 封装响应信息的工具类
 */
public class ResponseUtil {

    /**
     * 请求成功时返回的封装对象
     *
     * @param msg
     * @param data
     * @return
     */
    public static ResponseObject success(Integer code, String msg, Object data) {
        ResponseObject response = new ResponseObject();

        response.setStatus(code);
        response.setMessage(msg);
        response.setData(data);

        return response;
    }

    /**
     * 没有返回数据的成功响应信息
     *
     * @param msg
     * @return
     */
    public static ResponseObject success(Integer code, String msg) {
        ResponseObject response = success(code, msg, null);
        return response;
    }

    /**
     * 请求成功时返回的封装对象
     *
     * @param msg
     * @return
     */
    public static ResponseObject error(Integer code, String msg) {
        ResponseObject response = new ResponseObject();

        response.setStatus(code);
        response.setMessage(msg);

        return response;
    }
}
