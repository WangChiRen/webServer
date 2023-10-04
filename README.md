# web-server


一. 解釋本 repository 的目的與內容
目的主要是作者我有次去餐廳吃飯時
因為點了餐結果等了30分鐘還沒來
因為該餐廳還是採用手寫紙本的方式
後來才知道老闆把單子用丟
所以就製作了這個簡單的點菜系統
*但要注意的是，目前 web-server的專案是純後端，前端代碼在web-client中*

---------------------------------

二 src下的目錄有：
1. main/java/com/hamburger/hamburger
2. test/java/com/hamburger/hamburger

---------------------------------

三 針對src下**main**目錄做說明

---------------------------------

main目錄
目錄內的資料夾有：
1. config -> 配置類
2. controller -> 控制器層(用於接收請求響應結果)
3. ex -> 統一異常處理
4. mapper -> 持久層(和數據庫溝通)
5. pojo -> 數據傳輸對象
6. service -> 業務層(處理業務邏輯)
7. web -> 處理響應結果

---------------------------------

config目錄內的類有
1.MyBatisConfiguration
2.WebMvcConfiguration

---------------------------------

controller目錄內的類有
1.HamburgerController

---------------------------------

ex目錄內的類有
1.GlobalExceptionHandler
2.ServiceException

---------------------------------

mapper目錄內的類有
1.HamburgerMapper

---------------------------------

pojo目錄內的類有
1.dto/ HamburgerAddNewDTO
2.dto/ HamburgerUpdateByIdDTO
3.dto/ HamburgerUpdateOrderNumberDTO
4.entity/ Hamburger
5.entity/ HamburgerNumber
6.entity/ HamburgerUpdate
7.vo/ HamburgerDetailVO
8.vo/ HamburgerListItemVO
9.vo/ HamburgerListOrderVO
10.vo/ HamburgerUpdateDetailVO

---------------------------------

service目錄內的類有
1.IHamburgerService
2.HamburgerServiceImpl

---------------------------------

web目錄內的類有
1.JsonResult
2.ServiceCode

---------------------------------

四 針對較重要的類做說明
針對controller中的HamburgerController類做說明
1.添加訂單數據至訂單詳情頁中               public JsonResult addNew() 
2.將所有訂單數據添加到後台管理系統的表中    public JsonResult addOrder()
3.根據id刪除訂單詳情頁中的訂單             public JsonResult delete()
4.刪除全部訂單詳情頁中的訂單               public JsonResult deleteByData()
5.根據id修改訂單詳情頁中的訂單             public JsonResult update()
6.根據id修改管理員系統中的表數據           public JsonResult updateOrderNumber()
7.查詢所有訂單詳情頁中的數據               public JsonResult list()
8.查詢所有訂單編號數據                     public JsonResult listOrder()

---------------------------------

針對service中的IHamburgerService類做說明
1.處理添加訂單數據至訂單詳情頁中的邏輯         public void addNew
2.處理將所有訂單數據添加到後台管理系統的表中    public void addOrder()
3.處理根據id刪除訂單詳情頁中的訂單邏輯         public void deleteById()
4.處理刪除全部訂單詳情頁中的訂單邏輯           public void deleteByData()
5.處理查詢所有訂單詳情頁中的所有訂單           public List<HamburgerListItemVO> list()
6.處理查詢所有後台管理系統頁中的所有訂單        public List<HamburgerListOrderVO> listOrder()
7.處理根據id修改訂單詳情頁中的訂單數據          public void updateById()
8.處理修改訂單編號的邏輯                       public void updateOrderNumber()

---------------------------------

針對mapper中的HamburgerMapper類做說明
1.插入數據給到訂單詳情頁                       int insert()
2.插入所有數據給到後台管理系統頁                int insertOrder()
3.根據id刪除訂單詳情頁內數據                    int deleteById()
4.刪除全部的訂單詳情頁數據                      int deleteByData()
5.根據id修改訂單詳情頁數據                      int updateById()
6.修改訂單編號數據                              int updateOrderNumber()
7.查詢訂單詳情頁列表數據                         List<HamburgerListItemVO> list()
8.查詢後台管理系統頁列表數據                     List<HamburgerListOrderVO> listOrder()
9.統計所有訂單詳情頁的數據量                     int count()
10.根據id查訂單詳情頁的數據                      HamburgerDetailVO getById()
11.根據id查詢要修改的訂單數據                    HamburgerUpdateDetailVO getUpdateById()

---------------------------------

2.0版本

controller
AddMenuController
(完成) 新增AddMenuController類，處理AddMenuView接收或響應的數據

HamburgerMenuController
(完成) 新增HamburgerMenuController類，處理HamburgerMenuView接收或響應的數據

MenuListController
(完成) 新增MenuListController類，處理MenuListView接收或響應的數據

OrderManagementController
(完成) 新增OrderManagementController類，處理OrderManagementView接收或響應的數據

ShoppingCarController
(完成) 新增ShoppingCarController類，處理ShoppingCarView接收或響應的數據

service
AddMenuServiceImpl
(完成) 新增AddMenuServiceImpl類，負責處理前端AddMenuView的業務邏輯 5min
(完成) 新增繼承PictureBusiness，處理圖片邏輯 5min
(完成) 新增添加圖片方法upload() 30min
(完成) 新增添加目錄的方法addMenu() 1hr
(完成) 新增添加圖片的方法upload() 2hr

HamburgerMenuServiceImpl
(完成) 新增HamburgerMenuServiceImpl類，負責處理前端HamburgerMenuView的業務邏輯 5min



MenuListServiceImpl
(完成) 新增MenuListServiceImpl類，負責處理前端MenuListView的業務邏輯 5min
(完成) 新增繼承PictureBusiness，處理圖片邏輯 5min
(完成) 新增刪除管理員頁面內的數據的方法deleteMenuById() 1hr
(完成) 新增刪除圖片的方法remove() 1hr
(完成) 新增編輯數據的方法updateByIdMenu() 1hr
(完成) 新增編輯圖片的方法editUpload() 2hr

OrderManagementServiceImpl
(完成) 新增OrderManagementServiceImpl類，負責處理前端OrderManagementView的業務邏輯 5min


ShoppingCarServiceImpl
(完成) 新增ShoppingCarServiceImpl類，負責處理前端ShoppingCarView的業務邏輯 5min

IAddMenuService 
(完成) 新增AddMenuServiceImpl業務層接口 5min

IHamburgerMenuService
(完成) 新增HamburgerMenuServiceImpl業務層接口 5min

IMenuListService
(完成) 新增MenuListServiceImpl業務層接口 5min

IOrderManagementService
(完成) 新增OrderManagementServiceImpl業務層接口 5min

IShoppingCarService
(完成) 新增ShoppingCarServiceImpl業務層接口 5min

PictureBusiness
(完成) 新增處理圖片邏輯的父類PictureBusiness() 2hr


mapper
AddMenuMapper
(完成) 新增AddMenuMapper類，處理AddMenuView數據庫相關操作  5min

HamburgerMenuMapper
(完成) 新增HamburgerMenuMapper類，處理HamburgerMenuView數據庫相關操作  5min

MenuListMapper
(完成) 新增MenuListMapper類，處理MenuListView數據庫相關操作  5min

OrderManagementMapper
(完成) 新增OrderManagementMapper類，處理OrderManagementView數據庫相關操作  5min

ShoppingCarMapper
(完成) 新增ShoppingCarMapper類，處理ShoppingCarView數據庫相關操作  5min

---------------------------------

3.0版本

config
SecurityConfiguration
(完成) 新增SecurityConfiguration類，使用Spring Security處理認證與授權相關問題  2hr

controller
ForgetPasswordController
新增ForgetPasswordController類，處理ForgetPasswordView接收或響應的數據

LoginController
新增LoginController類，處理LoginView接收或響應的數據

service
AddMenuServiceImpl
(完成) 修改insertAddAdmin方法，檢查帳號、手機、mail數據是否存在於數據庫中 2hr
(完成) 修改insertAddAdmin方法，根據 description 查詢 ams_role 表內的數據id 2hr

---------------------------------

4.0版本

-使用Redis儲存列表數據

config
RedisConfiguration
(完成) 新增RedisConfiguration類，使用Redis儲存一些數據，在程式的執行過程中，將優先從Redis中讀寫數據，以提高效率  4hr
ScheduledConfiguration
(完成) 新增ScheduledConfiguration類，開啟排程任務  1hr

schedule
(完成) 新增CacheSchedule類，開啟排程任務，根據@Scheduled註解配置週期性的執行  1hr

repo
(完成) 新增IAddAdminRepository介面
(完成) 新增IAdminListRepository介面
(完成) 新增IHamburgerMenuRepository介面
(完成) 新增IMenuListRepository介面
(完成) 新增IOrderManagementRepository介面
(完成) 新增AddAdminRepository實現類，用於存取 MySQL 中的 ams_role 列表數據，以及刪除Redis中的列表數據  
(完成) 新增AdminListRepository實現類，用於存取 MySQL 中的 ams_admin 列表數據，以及刪除Redis中的列表數據  
(完成) 新增HamburgerMenuRepository實現類，用於存取 MySQL 中的 hamburger_menu 列表數據，以及刪除Redis中的列表數據  
(完成) 新增MenuListRepository實現類，用於存取 MySQL 中的 add_menu 列表數據，以及刪除Redis中的列表數據  
(完成) 新增OrderManagementRepository實現類，用於存取 MySQL 中的 hamburger_order 列表數據，以及刪除Redis中的列表數據 
(完成) 新增SuperRepository父類，將AddAdminRepository、AdminListRepository、HamburgerMenuRepository、
MenuListRepository、OrderManagementRepository，共有的方法提取到父類中






























