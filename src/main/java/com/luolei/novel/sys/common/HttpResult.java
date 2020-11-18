package com.luolei.novel.sys.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class HttpResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";



    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(0),
        /**失败*/
        FAIL(1),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /** 状态类型 */
    private Type type;

    /** 状态码 */
    private int code;

    /** 返回内容 */
    private String msg;

    /** 数据对象 */
    private Object data;


    /**
     * 初始化一个新创建的 HttpResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     */
    public HttpResult(Type type, String msg)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 HttpResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public HttpResult(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static HttpResult success()
    {
        return HttpResult.success("操作成功");
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static HttpResult success(String msg)
    {
        return HttpResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static HttpResult success(String msg, Object data)
    {
        return new HttpResult(Type.SUCCESS, msg, data);
    }

    /**
     * 返回失败消息
     *
     * @return 成功消息
     */
    public static HttpResult fail()
    {
        return HttpResult.fail("操作失败");
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static HttpResult fail(String msg)
    {
        return HttpResult.fail(msg, null);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static HttpResult fail(String msg, Object data)
    {
        return new HttpResult(Type.FAIL, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static HttpResult warn(String msg)
    {
        return HttpResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static HttpResult warn(String msg, Object data)
    {
        return new HttpResult(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static HttpResult error()
    {
        return HttpResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static HttpResult error(String msg)
    {
        return HttpResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static HttpResult error(String msg, Object data)
    {
        return new HttpResult(Type.ERROR, msg, data);
    }
}
