package com.hamburger.hamburger.mapper;



import com.hamburger.hamburger.pojo.vo.LoginVO;
import org.springframework.stereotype.Repository;

/**
 * LoginMapper 接口
 */
@Repository
public interface LoginMapper {

    /**
     * 根據帳號查詢登入相關訊息
     * @param account 帳號
     * @return 沒有匹配返回null
     */
    LoginVO getByAccount(String account);

}
