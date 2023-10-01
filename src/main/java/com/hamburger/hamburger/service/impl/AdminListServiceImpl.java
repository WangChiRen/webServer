package com.hamburger.hamburger.service.impl;


import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.AdminListMapper;
import com.hamburger.hamburger.pojo.dto.AdminListUpdateDTO;
import com.hamburger.hamburger.pojo.entity.AdminListRoleUpdate;
import com.hamburger.hamburger.pojo.entity.AdminListUpdate;
import com.hamburger.hamburger.pojo.entity.MenuListUpdateMenu;
import com.hamburger.hamburger.pojo.vo.AdminListDescriptionVO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.DeleteAdminByIdVO;
import com.hamburger.hamburger.pojo.vo.HamburgerDetailMenuVO;
import com.hamburger.hamburger.service.IAdminListService;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 業務層:負責處理前端 AdminListView 的業務邏輯
 */
@Slf4j
@Service
public class AdminListServiceImpl implements IAdminListService {

    @Autowired
    private AdminListMapper adminListMapper;

    @Transactional(rollbackFor = {Exception.class})
    public void updateByIdAdmin(AdminListUpdateDTO adminListUpdateDTO, Integer id) {
        log.debug("開始編輯員工列表數據業務,id={},數據:{}", id, adminListUpdateDTO);

        //檢查數據是否存在
        DeleteAdminByIdVO deleteAdminByIdVO = adminListMapper.getAdminId(id);
        if (deleteAdminByIdVO == null) {
            String message = "修改員工詳情頁數據失敗,修改的數據不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        } else {
            // 創建實體對象
            AdminListUpdate adminListUpdate = new AdminListUpdate();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(adminListUpdateDTO, adminListUpdate);

            log.debug("開始編輯,id={},數據:{}", id, adminListUpdate);

            adminListUpdate.setId(id);
            adminListUpdate.setUsername(adminListUpdate.getUsername());
            adminListUpdate.setAccount(adminListUpdate.getAccount());
            adminListUpdate.setPhone(adminListUpdate.getPhone());
            adminListUpdate.setMail(adminListUpdate.getMail());
            adminListUpdate.setBirthday(adminListUpdate.getBirthday());
            adminListUpdate.setEnable(adminListUpdate.getEnable());
            adminListUpdate.setDescription(adminListUpdate.getDescription());

            //根據id修改數據
            int rows = adminListMapper.updateByIdAdmin(adminListUpdate);
            log.debug("rows:{}", rows);
            if (rows != 1) {
                String message = "修改失敗,狀態碼001,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_UPDATE, message);
            }else {

                AdminListRoleUpdate adminListRoleUpdate = new AdminListRoleUpdate();

                //要修改的 admin_id 的號碼
                adminListRoleUpdate.setAdmin_id(adminListUpdate.getId());

                //要修改的 ams_role 的名稱是
                adminListRoleUpdate.setDescription(adminListUpdate.getDescription());
                log.debug("ams_admin_role 修改的數據是:{}",adminListUpdate.getDescription());

                //要修改的 role_id 的數據是
                AdminListDescriptionVO adminListDescriptionVO = adminListMapper.getByDescriptionId(adminListUpdate.getDescription());
                adminListRoleUpdate.setRole_id(adminListDescriptionVO.getId());
                log.debug("ams_admin_role 修改的role_id的是:{}",adminListDescriptionVO.getId());



                int i = adminListMapper.updateByIdAdminRole(adminListRoleUpdate);

                if (i != 1) {
                    String message = "修改失敗,狀態碼002,請稍後重試";
                    throw new ServiceException(ServiceCode.ERR_UPDATE, message);
                }
            }
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteAdminById(Integer id) {
        log.debug("開始刪除管理員頁的數據業務,id={}", id);

        DeleteAdminByIdVO deleteAdminByIdVO = adminListMapper.getAdminId(id);

        if (deleteAdminByIdVO == null) {
            String message = "刪除員工編輯頁面中的數據失敗,刪除的數據(id=" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        int rows = adminListMapper.deleteAdminById(id);
        if (rows != 1) {
            String message = "刪除員工編輯頁面中的數據失敗,狀態碼001,服務器忙,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        } else {

            int i = adminListMapper.deleteAdminRoleById(id);

            if (i != 1) {
                String message = "刪除員工編輯頁面中的數據失敗,狀態碼002,服務器忙,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_DELETE, message);
            }
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public List<AdminListVO> adminList() {
        log.debug("開始處理查詢 ams_admin 表中的業務");
        return adminListMapper.adminList();
    }
}
