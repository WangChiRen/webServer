package com.hamburger.hamburger.ex.handler;

import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.web.JsonResult;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
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
    public JsonResult handleThrowable(Throwable e){
        log.error("統一處理未明確的異常【{}】，將向客戶端響應:{}",e.getClass().getName(),e.getMessage());
        String message = "服务器忙，请联系管理员！";
        return JsonResult.fail(ServiceCode.ERR_UNKNOWN,message);
    }

    @ExceptionHandler
    public JsonResult handleIOException(IOException e){
        log.error("統一處理IOException異常,將向客戶端響應:{}", e.getMessage());
        String message = "圖片保存失敗，請檢查路徑是否存在";
        return JsonResult.fail(ServiceCode.ERR_IMG_PATH,message);
    }


}
