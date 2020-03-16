package com.example.login.Utils;

import com.example.login.domain.ResponseObject;

public class ResponseUtil {
    public static ResponseObject success(Integer code,String msg,Object data){
        ResponseObject res = new ResponseObject();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }
    public static ResponseObject success(Integer code,String msg){
        ResponseObject res = new ResponseObject();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }
    public static ResponseObject failed(Integer code,String msg){
        ResponseObject res = new ResponseObject();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }
}
