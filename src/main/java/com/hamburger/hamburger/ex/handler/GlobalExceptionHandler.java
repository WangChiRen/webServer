package com.hamburger.hamburger.ex.handler;

import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.web.JsonResult;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

/**
 * 統一異常處理類
 */
//@ControllerAdvice
//@ResponseBody
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult handleServiceException(ServiceException e) {
        log.error("統一處理ServiceException異常,將向客戶端響應:{}", e.getMessage());
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult handleThrowable(Throwable e) {
        log.error("統一處理未明確異常[{}],將向客戶端響應:{}", e.getClass().getName(), e.getMessage());
        String message = "服務器忙線,請聯繫管理員";
        return JsonResult.fail(ServiceCode.ERR_UNKNOWN,message);
    }


}
