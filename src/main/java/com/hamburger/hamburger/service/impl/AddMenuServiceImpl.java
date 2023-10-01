package com.hamburger.hamburger.service.impl;

import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.AddMenuMapper;
import com.hamburger.hamburger.pojo.dto.AddMenuDTO;
import com.hamburger.hamburger.pojo.entity.AddMenu;
import com.hamburger.hamburger.service.IAddMenuService;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 業務層:負責處理前端 AddMenuView 的業務邏輯
 */
@Slf4j
@Service
public class AddMenuServiceImpl extends PictureBusiness implements IAddMenuService {


    @Autowired
    private AddMenuMapper addMenuMapper;


    @Transactional(rollbackFor = {Exception.class})
    public void addMenu(@RequestBody AddMenuDTO addMenuDTO) {
        log.debug("開始處理添加表單數據業務,參數:{}", addMenuDTO);
        // 創建實體對象
        AddMenu addMenu = new AddMenu();
        // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
        //轉換對象(數據源,複製到哪)
        //將當前方法參數的屬性值複製到實體類的屬性中
        BeanUtils.copyProperties(addMenuDTO, addMenu);
        // 執行圖片保存操作
        log.debug("添加圖片的名稱:{}", getAddFileName());
        addMenu.setCommodity(getAddFileName());
        // 將管理員信息寫入到數據庫
        int rows = addMenuMapper.insertAddMenu(addMenu);
        if (rows != 1) {
            String message = "添加失敗,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
    }


    @Transactional(rollbackFor = {Exception.class})
    public String upload(@RequestParam("picFile") MultipartFile picFile) {
        log.debug("開始處理添加圖片業務,參數:{}", picFile);
        return super.uploadImg(picFile, "upload");
    }
}
