package com.hamburger.hamburger.web;


import com.hamburger.hamburger.ex.ServiceException;
import lombok.Data;

/**
 * 響應json結果
 */
@Data
public class JsonResult {

    /**
     * 業務狀態碼
     */
    private Integer code;

    /**
     * 錯誤時消息
     */
    private String message;

    /**
     * 處理成功時，需要響應的數據
     */
    private Object data;

    // 響應成功(不需要響應數據)
    public static com.hamburger.hamburger.web.JsonResult ok(){
        return ok(null);
    }

    // 響應成功(需要響應數據)
    public static com.hamburger.hamburger.web.JsonResult ok(Object data){
        com.hamburger.hamburger.web.JsonResult jsonResult = new com.hamburger.hamburger.web.JsonResult();
        jsonResult.code = ServiceCode.OK;
        jsonResult.data = data;
        return jsonResult;
    }

    public static com.hamburger.hamburger.web.JsonResult fail(ServiceException e){
        return fail(e.getServiceCode(),e.getMessage());
    }

    public static com.hamburger.hamburger.web.JsonResult fail(Integer code, String message){
        com.hamburger.hamburger.web.JsonResult jsonResult = new com.hamburger.hamburger.web.JsonResult();
        jsonResult.code = code;
        jsonResult.message = message;
        return jsonResult;
    }

}
