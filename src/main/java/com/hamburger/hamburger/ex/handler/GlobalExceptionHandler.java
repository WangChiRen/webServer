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
    public JsonResult handleBindException(BindException e) {
        log.error("統一處理BindException異常,將向客戶端響應:{}", e.getMessage());

        //一個錯誤
        //String message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        // 多個錯誤
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        //        StringBuilder builder = new StringBuilder();
        //for(FieldError fieldError : fieldErrors){
        //builder.append(fieldError.getDefaultMessage());
        //builder.append("; "); // 结尾多分號
        //}
        //String message = builder.toString();

        // new StringJoiner(分隔符,[前缀],[後缀])
        StringJoiner joiner = new StringJoiner("; ","錯誤提示：","");
        for(FieldError fieldError : fieldErrors){
            joiner.add(fieldError.getDefaultMessage());
        }
        String message = joiner.toString();

        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST, message);
    }


    @ExceptionHandler
    public JsonResult handleThrowable(Throwable e) {
        log.error("統一處理未明確異常[{}],將向客戶端響應:{}", e.getClass().getName(), e.getMessage());
        String message = "服務器忙線,請聯繫管理員";
        return JsonResult.fail(ServiceCode.ERR_UNKNOWN,message);
    }


}
