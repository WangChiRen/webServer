package com.hamburger.hamburger.mapper;



import com.hamburger.hamburger.pojo.entity.AdminListRoleUpdate;
import com.hamburger.hamburger.pojo.entity.AdminListUpdate;
import com.hamburger.hamburger.pojo.vo.AddAdminDescriptionVO;
import com.hamburger.hamburger.pojo.vo.AdminListDescriptionVO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.DeleteAdminByIdVO;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * AdminListMapper 接口
 */
@Repository
public interface AdminListMapper {

    /**
     * 根據id刪除 ams_admin 表內的數據
     *
     * @param id 員工詳情頁內的id
     * @return 受引響行數
     */
    int deleteAdminById(Integer id);

    /**
     * 根據 admin_id 刪除 ams_admin_role 表內的數據
     *
     * @param admin_id ams_admin_role表內的 admin_id 數據
     * @return 受引響行數
     */
    int deleteAdminRoleById(Integer admin_id);

    /**
     * 根據id修改員工詳情數據
     *
     * @param adminListUpdate 修改MenuList的數據
     * @return 受引響行數
     */
    int updateByIdAdmin(AdminListUpdate adminListUpdate);


    /**
     * 根據 description 修改 ams_admin_role 表中的 role_id 數據
     *
     * @param adminListRoleUpdate 修改 ams_admin_role 表中的 role_id 數據
     * @return 受引響行數
     */
    int updateByIdAdminRole(AdminListRoleUpdate adminListRoleUpdate);


    /**
     * 根據 name 查詢 ams_role 表內的數據id
     *
     * @param name ams_role 表中添加數據的 name
     * @return id數據
     */
    AdminListDescriptionVO getByDescriptionId(String name);


    /**
     * 根據id查詢 ams_admin 表內的數據
     *
     * @param id 員工詳情頁內的id
     * @return 數據詳情
     */
    DeleteAdminByIdVO getAdminId(Integer id);

    /**
     * 查詢 ams_admin 列表數據
     *
     * @return 列表數據
     */
    List<AdminListVO> adminList();


}
