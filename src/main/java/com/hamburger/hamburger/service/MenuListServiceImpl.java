package com.hamburger.hamburger.service;


import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.MenuListMapper;
import com.hamburger.hamburger.pojo.dto.HamburgerUpdateMenuDTO;
import com.hamburger.hamburger.pojo.entity.HamburgerEditUpload;
import com.hamburger.hamburger.pojo.entity.HamburgerUpdateMenu;
import com.hamburger.hamburger.pojo.vo.HamburgerDetailMenuVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;
import com.hamburger.hamburger.pojo.vo.HamburgerRemoveVO;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 業務層:負責處理前端 MenuListView 的業務邏輯
 */
@Slf4j
@Service
public class MenuListServiceImpl extends PictureBusiness implements IMenuListService {


    @Autowired
    private MenuListMapper menuListMapper;


    /**
     * 根據id刪除管理員頁面內的數據
     */
    public void deleteMenuById(Integer id) {
        log.debug("開始刪除管理員頁的數據業務,id={}", id);

        HamburgerDetailMenuVO hamburgerDetailMenuVO = menuListMapper.getAddMenuId(id);

        if (hamburgerDetailMenuVO == null) {
            String message = "刪除管理員頁面中的數據失敗,刪除的數據(id=" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        int rows = menuListMapper.deleteMenuById(id);
        if (rows != 1) {
            String message = "刪除管理員頁面中的數據失敗,服務器忙,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        } else {
            MenuListServiceImpl menuListService = new MenuListServiceImpl();
            menuListService.remove(hamburgerDetailMenuVO.getCommodity());
        }
    }


    /**
     * MenuList 刪除圖片方法
     *
     * @param pictureName 要刪除的圖片名稱
     */
    public void remove(String pictureName) {
        log.debug("開始處理刪除圖片業務,數據:{}", pictureName);
        if (pictureName != null) {
            String filePath = "C:/VUE-Workspace/login-web-client/src/assets/" + pictureName;
            new File(filePath).delete();//删除文件
        } else {
            String message = "刪除圖片失敗,請聯繫管理員";
            throw new ServiceException(ServiceCode.ERR_IMG_REMOVE, message);
        }

    }


    /**
     * MenuList 編輯數據方法
     *
     * @param hamburgerUpdateMenuDTO 編輯的數據
     * @param id                     要編輯的id
     */
    @Transactional(rollbackFor = {Exception.class})
    public void updateByIdMenu(HamburgerUpdateMenuDTO hamburgerUpdateMenuDTO, Integer id) {
        log.debug("開始編輯目錄數據業務,id={},數據:{}", id, hamburgerUpdateMenuDTO);

        //檢查數據是否存在
        HamburgerDetailMenuVO hamburgerDetailMenuVO = menuListMapper.getAddMenuId(id);
        if (hamburgerDetailMenuVO == null) {
            String message = "修改菜單詳情頁數據失敗,修改的數據不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        } else {

            // 創建實體對象
            HamburgerUpdateMenu hamburgerUpdateMenu = new HamburgerUpdateMenu();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(hamburgerUpdateMenuDTO, hamburgerUpdateMenu);

            log.debug("開始編輯,id={},數據:{}", id, hamburgerUpdateMenu);

            hamburgerUpdateMenu.setId(id);
            hamburgerUpdateMenu.setMeals(hamburgerUpdateMenu.getMeals());
            hamburgerUpdateMenu.setDescride(hamburgerUpdateMenu.getDescride());
            hamburgerUpdateMenu.setUnitprice(hamburgerUpdateMenu.getUnitprice());
            hamburgerUpdateMenu.setRecommend(hamburgerUpdateMenu.getRecommend());
            hamburgerUpdateMenu.setCommodity(hamburgerUpdateMenu.getCommodity());

            super.setEditFileNameId(hamburgerUpdateMenu.getId());


            //根據id修改數據
            int rows = menuListMapper.updateByIdMenu(hamburgerUpdateMenu);
            log.debug("rows:{}", rows);
            if (rows != 1) {
                String message = "修改失敗,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_UPDATE, message);
            }
        }
    }


    @Transactional(rollbackFor = {Exception.class})
    public String editUpload(@RequestParam("picFile") MultipartFile picFile) {
        log.debug("開始處理編輯圖片業務,參數:{}", picFile);
        String editFileName = super.uploadImg(picFile, "editUpload");// 調用父類的方法並傳遞方法名
            return editFileName;
        }



    @Transactional(rollbackFor = {Exception.class})
    public List<HamburgerListEditMenuVO> listEditMenu() {
        log.debug("開始處理查詢addMenu表中的業務");
        return menuListMapper.listEditMenu();
    }


}
