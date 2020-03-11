package com.sunshine.domain.vo;

/**
 * 返回对象的信息封装
 */
public class ResponseObject {
    /**
     * 返回信息的状态
     */
    private int status;
    /**
     * 返回描述信息
     */
    private String message;
    /**
     * 返回的具体数据
     */
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
