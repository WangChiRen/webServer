package com.hamburger.hamburger.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.hamburger.hamburger.validation.LoginValidationConst.*;


/**
 * 員工登入的數據
 */
@Data
public class LoginDTO implements Serializable {

    /**
     * 帳號
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_ACCOUNT)
    @Pattern(regexp = PATTERN_REGEXP_ACCOUNT, message = PATTERN_MESSAGE_ACCOUNT)
    private String account;

    /**
     * 密碼
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_PASSWORD)
    @Pattern(regexp = PATTERN_REGEXP_PASSWORD, message = PATTERN_MESSAGE_PASSWORD)
    private String password;

}
