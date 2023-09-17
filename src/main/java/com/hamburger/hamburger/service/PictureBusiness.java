package com.hamburger.hamburger.service;


import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.AddMenuMapper;
import com.hamburger.hamburger.mapper.MenuListMapper;
import com.hamburger.hamburger.pojo.dto.HamburgerAddMenuDTO;
import com.hamburger.hamburger.pojo.entity.HamburgerEditUpload;
import com.hamburger.hamburger.pojo.vo.HamburgerRemoveVO;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 處理圖片邏輯(父類)
 */
@Slf4j
@Service
public class PictureBusiness {


    @Autowired
    private AddMenuMapper addMenuMapper;


    @Autowired
    private MenuListMapper menuListMapper;


    //編輯圖片的名稱
    private static String editFileName;


    //編輯圖片的id
    private static Integer editFileNameId;


    //添加圖片的名稱
    private static String addFileName;


    public static String getAddFileName() {
        return addFileName;
    }


    public void setEditFileNameId(Integer id) {
        editFileNameId = id;
    }


    @Transactional(rollbackFor = {Exception.class})
    public String uploadImg(@RequestParam("picFile") MultipartFile picFile, String methodName) {
        String resultFileName = ""; // 初始化一個變量來存儲文件名

        log.debug("開始處理添加圖片業務,參數:{}, 方法名:{}", picFile, methodName);

        //準備保存圖片的文件夾路徑
        String dirPath = "C:/VUE-Workspace/login-web-client/src/assets";
        //得到文件原始文件名
        String fileName = picFile.getOriginalFilename();

        int count = addMenuMapper.countByName(fileName);
        if (count > 0) {
            String message = "添加失敗，圖片名稱【" + fileName + "】已經存在！";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        } else {

            if("editUpload".equals(methodName)){
                //刪除舊圖片
                log.debug("刪除的圖片id是:{}", editFileNameId);
                HamburgerRemoveVO commodityName = menuListMapper.getCommodityName(editFileNameId);
                log.debug("刪除的圖片名稱:{}", commodityName.getCommodity());
                MenuListServiceImpl menuListService = new MenuListServiceImpl();
                menuListService.remove(commodityName.getCommodity());
            }

            File dirFile = new File(dirPath);
            //如果該文件夾不存在 則創建此文件夾
            if (!dirFile.exists()) {
                dirFile.mkdirs();//創建文件夾
            }
            //得到文件的完整路徑
            String filePath = dirPath + "/" + fileName;
            //把文件保存到此路徑異常拋出
            try {
                picFile.transferTo(new File(filePath));
            } catch (IOException e) {
                String message = "請檢查路徑是否存在";
                throw new ServiceException(ServiceCode.ERR_IMG_PATH, message);
            }
            log.debug("圖片添加完成! 請去此路徑檢查圖片是否存在:{}", filePath);
            if ("upload".equals(methodName)) {
                addFileName = fileName;

                HamburgerAddMenuDTO hamburgerAddMenuDTO = new HamburgerAddMenuDTO();
                hamburgerAddMenuDTO.setCommodity(addFileName);
                log.debug("upload,fileName:{}", addFileName);

                resultFileName = addFileName; //要返回的數據

            } else if ("editUpload".equals(methodName)) {
                editFileName = fileName;

                // 創建實體對象
                HamburgerEditUpload hamburgerEditUpload = new HamburgerEditUpload();
                // 要修改的id號
                hamburgerEditUpload.setId(editFileNameId);
                log.debug("修改AddMenu表中的id:{}", editFileNameId);
                // 修改的圖片名稱
                hamburgerEditUpload.setCommodity(editFileName);
                log.debug("修改的圖片名稱:{}", editFileName);
                menuListMapper.updateByIdEditUpload(hamburgerEditUpload);

                resultFileName = editFileName; //要返回的數據

            }
            return resultFileName;
        }
    }
}
