package com.luolei.novel.sys.exception;


import com.alibaba.fastjson.JSON;
import com.luolei.novel.sys.common.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常捕获
     * @param e 捕获的异常
     * @return 封装的返回对象
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResult handlerException(Exception e) {
        HttpResult.Type resultCodeEnum;
        // 自定义异常
        if (false) {
//            resultCodeEnum = HttpResult.Type.FAIL;
//            resultCodeEnum.(getConstraintViolationErrMsg(e));
//            log.error("tokenVerificationException：{}", resultCodeEnum.getMessage());
        }else {
            // 其他异常，当我们定义了多个异常时，这里可以增加判断和记录
            resultCodeEnum = HttpResult.Type.FAIL;
//            resultCodeEnum.setMessage(e.getMessage());
            log.error("common exception:{}", JSON.toJSONString(e));
        }
        return HttpResult.error("错误",resultCodeEnum);
    }

}
