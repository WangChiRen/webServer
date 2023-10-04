package com.hamburger.hamburger.service.impl;


import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.AddAdminMapper;
import com.hamburger.hamburger.pojo.dto.AddAdminDTO;
import com.hamburger.hamburger.pojo.entity.AddAdmin;
import com.hamburger.hamburger.pojo.entity.AddAdminRole;
import com.hamburger.hamburger.pojo.vo.*;
import com.hamburger.hamburger.repo.IAddAdminRepository;
import com.hamburger.hamburger.service.IAddAdminService;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 業務層:負責處理前端 AddAdminView 的業務邏輯
 */
@Slf4j
@Service
public class AddAdminServiceImpl implements IAddAdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AddAdminMapper addAdminMapper;

    @Autowired
    private IAddAdminRepository addAdminRepository;


    public void insertAddAdmin(AddAdminDTO addAdminDTO) {
        log.debug("開始處理添加表單數據業務,參數:{}", addAdminDTO);

        //檢查帳號數據是否存在
        AddAdminAccountVO addAdminAccountVO = addAdminMapper.getAdminAccount(addAdminDTO.getAccount());
        //檢查手機數據是否存在
        AddAdminAccountVO addAdminPhoneVO = addAdminMapper.getAdminPhone(addAdminDTO.getPhone());
        //檢查 mail 數據是否存在
        AddAdminAccountVO addAdminMailVO = addAdminMapper.getAdminMail(addAdminDTO.getMail());

        if (addAdminAccountVO != null) {
            String message = "添加數據失敗,添加的帳號已存在";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        } else if (addAdminPhoneVO != null) {
            String message = "添加數據失敗,添加的手機已存在";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);

        } else if (addAdminMailVO != null) {
            String message = "添加數據失敗,添加的 mail 已存在";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        } else {
            // 創建實體對象
            AddAdmin addAdmin = new AddAdmin();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(addAdminDTO, addAdmin);

            //將原密碼從 addAdmin 對象中取出
            String rawPassword = addAdmin.getPassword();

            //通過 Security 的 passwordEncoder 中的 encode 方法將原密碼 (rawPassword) 做加密
            String encodePassword = passwordEncoder.encode(rawPassword);

            //將加密過後的密碼 (encodePassword) 存回至addAdmin對象中
            addAdmin.setPassword(encodePassword);

            log.debug("加密後的密碼數據是:{}",encodePassword);

            // 將管理員信息寫入到數據庫
            int rows = addAdminMapper.insertAddAdmin(addAdmin);
            if (rows != 1) {
                String message = "添加員工失敗,狀態碼001,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_INSERT_ADD_ADMIN, message);
            }else {
            log.debug("添加數據.....");
                AddAdminRole addAdminRole = new AddAdminRole();

                //ams_admin 新添加的id
                AddAdminRoleVO addAdminRoleVO = addAdminMapper.getByAccountId(addAdmin.getAccount());
                log.debug("ams_admin 新添加的數據是:{}", addAdminRoleVO);
                addAdminRole.setAdmin_id(addAdminRoleVO.getId());

                //根據 description 查詢 ams_role 表內的數據id
                AddAdminDescriptionVO addAdminDescriptionVO = addAdminMapper.getByDescriptionId(addAdminRoleVO.getDescription());
                log.debug("ams_role 中的數據是:{}", addAdminDescriptionVO);
                addAdminRole.setRole_id(addAdminDescriptionVO.getId());

                int row = addAdminMapper.insertAddAdminRole(addAdminRole);
                log.debug("ams_admin_role 中間表添加成功");
                if (row != 1) {
                    //ams_admin_role 中間表添加失敗
                    String message = "添加員工失敗,狀態碼002,請稍後重試";
                    throw new ServiceException(ServiceCode.ERR_INSERT_ADD_ADMIN, message);
                }
            }
        }
    }


    public List<AddAdminVO> addAdminList() {
        log.debug("開始處理查詢 ams_role 表中的業務");
        return addAdminRepository.addAdmin();
    }
}
