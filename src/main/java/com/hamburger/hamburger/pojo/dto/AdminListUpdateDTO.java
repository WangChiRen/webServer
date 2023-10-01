package com.hamburger.hamburger.pojo.dto;


import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

import static com.hamburger.hamburger.validation.AdminListValidationConst.*;

@Data
public class AdminListUpdateDTO implements Serializable {

    /**
     * 姓名
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_USERNAME)
    @Pattern(regexp = PATTERN_REGEXP_USERNAME, message = PATTERN_MESSAGE_USERNAME)
    private String username;


    /**
     * 帳號
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_ACCOUNT)
    @Pattern(regexp = PATTERN_REGEXP_ACCOUNT, message = PATTERN_MESSAGE_ACCOUNT)
    private String account;


    /**
     * 手機號碼
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_PHONE)
    @Pattern(regexp = PATTERN_REGEXP_PHONE, message = PATTERN_MESSAGE_PHONE)
    private String phone;


    /**
     * 電子郵箱
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_MAIL)
    @Email(message = EMAIL_MESSAGE_MAIL)
    private String mail;


    /**
     * 生日
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_BIRTHDAY)
    @Pattern(regexp = PATTERN_REGEXP_BIRTHDAY, message = PATTERN_MESSAGE_BIRTHDAY)
    private String birthday;


    /**
     * 帳號是否啟用:1 = 啟用,0 = 不啟用
     */
    @Max(value = 1, message = MAX_MESSAGE_VALUE_ENABLE)
    @Min(value = 0, message = MIN_MESSAGE_VALUE_ENABLE)
    private Integer enable;

    /**
     * 描述
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_DESCRIPTION)
    @Pattern(regexp = PATTERN_REGEXP_DESCRIPTION, message = PATTERN_MESSAGE_DESCRIPTION)
    private String description;

}
