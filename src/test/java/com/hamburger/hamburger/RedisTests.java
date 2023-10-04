package com.hamburger.hamburger;


import com.hamburger.hamburger.pojo.vo.HamburgerDetailVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    /**
     * 設定對應的值(寫入資料)
     */
    @Test
    public void testOpsForValueSet() {
        //準備數
        String key = "name";
        String value = "Tom";

        // 取得值運算子(只要在Redis中處理資料的值 - String，則需要取得運算元 - ValueOperations)
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();

        // 使用操作器寫入數據
        opsForValue.set(key, value);

        log.debug("已經向Redis中寫入簡單的String數據");
    }


    /**
     * 設定對應的值(寫入資料 - 有效期限)
     */
    @Test
    public void testOpsForValueSet2() {
        // 準備數據
        String key = "mail";
        String value = "1111";
        long timeout = 1L;

        // 取得值運算子(只要在Redis中處理資料的值 - String，則需要取得運算元 - ValueOperations)
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();

        // 使用操作器寫入數據
        opsForValue.set(key, value, timeout, TimeUnit.MINUTES);

        // 視覺化工具 TTL代表過期時間(Time To Live)：-1代表永久有效，-2代表過期
        log.debug("已經在Redis中寫入簡單的String資料,有效期限為{}分鐘", timeout);

    }

    /**
     * 設定對應的值(寫入資料 - 品牌物件資料)
     */
    @Test
    public void testOpsForValueSet3(){
        String key = "brand01";
        HamburgerDetailVO hamburgerDetailVO = new HamburgerDetailVO();
        hamburgerDetailVO.setId(999);
        hamburgerDetailVO.setTotal(1000);

        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();

        // 配置類別中配置了值序列化器是json的,物件值也會轉換為json字串
        opsForValue.set(key,hamburgerDetailVO);
        log.debug("已經在Redis中寫入物件類型數據，寫入的物件：{}",hamburgerDetailVO);

    }

    /**
     * 取得對應的值(讀資料)
     */
    @Test
    public void testOpsForValueGet() {
//        String key = "name";
        String key = "brand01";

        // 取得值運算子(只要在Redis中處理資料的值 - String，則需要取得運算元 - ValueOperations)
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();

        Serializable value = opsForValue.get(key);

        log.debug("已經從Redis讀取到key={}的資料：{}", key, value);
        log.debug("從Redis讀取到的資料的型別{}", value.getClass().getName());
    }

    /**
     * 清除Redis
     */
    @Test
    public void testDelete() {
        String key = "brand";
        Boolean delete = redisTemplate.delete(key);

        log.debug("刪除Redis中key={}的數據，結果:{}", key, delete);
    }

    /**
     * 遍歷所有的key
     */
    @Test
    public void testKeys() {
        String keyPattern = "*";
        Set<String> keys = redisTemplate.keys(keyPattern);

        log.debug("透過key的模式【{}】找到的key：{}", keyPattern, keys);

        for (String key : keys) {
            log.debug("\tkey={}", key); // \t 製表符 - 補全目前字串長度至8的整數倍
        }
    }

    /**
     * 寫入列表
     */
    @Test
    public void testOpsForListRightPush(){
        String key = "hamburgerListMenuVOS";

        List<HamburgerListMenuVO> hamburgerListMenuVOS = new ArrayList<>();
        for(int i=0; i<10; i++){
            HamburgerListMenuVO hamburgerListMenuVO = new HamburgerListMenuVO();
            hamburgerListMenuVO.setId(i);
            hamburgerListMenuVO.setDescride("描述*"+i);
            hamburgerListMenuVOS.add(hamburgerListMenuVO);
        }

        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();

        for(HamburgerListMenuVO vo : hamburgerListMenuVOS){
            // 堆疊結構（雙端佇列）
            opsForList.rightPush(key,vo);
        }
        log.debug("已經寫入List型資料到Redis");
    }

    /**
     * 取得列表長度
     */
    @Test
    public void testOpsForListSize(){

        String key = "hamburgerListMenuVOS";
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        Long size = opsForList.size(key);
        log.debug("讀取key={}的list型數據的長度:{}",key,size);

    }

    /**
     * 取得對應位置的元素
     */
    @Test
    public void testOpsForListIndex(){

        String key = "hamburgerListMenuVOS";
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        // 以長度為10的List為例 ，有效索引[0,9]和[-10,-1]
        // 如果正數或負數索引值越界，則傳回null
        Long index = 0L;
        Serializable serializable = opsForList.index(key, index);
        log.debug("讀取key={}的list型數據的索引為:{}的數據{}",key,index,serializable);

    }

    /**
     * 取得整個列表
     */
    @Test
    public void testOpsForListRange(){

        String key = "hamburgerListMenuVOS";
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();

        // start = 0L end = 9L >>> 全部
        // start = 0L end = 10L >>> 全部
        // start = 0L end = 0L >>> 第一個元素
        // start = 0L end = -1L >>> 全部 - 推薦
        // start = 0L end = -7L >>> 第1個到第4個
        // 元素下標： 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        // 元素下標：-10, -9, -8, -7, -6, -5, -4, -3, -2, -1

        Long start = 0L;
        Long end = -1L;
        List<Serializable> list = opsForList.range(key, start, end);
        log.debug("讀取key={}的List型資料的從{}到{}資料集：{}",key,start,end,list);


    }

    // 隊列(先進先出)
    @Test
    public void testQueue(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3); // 存-隊尾
        queue.offer(4);
        System.out.println(queue);

        Integer i1 = queue.poll(); // 取 - 取出隊首元素(對列刪除隊首)
        System.out.println(i1);
        System.out.println(queue);
        i1 = queue.poll();
        System.out.println(i1);
        System.out.println(queue);

        Integer peek = queue.peek();// 取 - 取出隊首元素(對列不刪除隊首)
        System.out.println(peek);
        System.out.println(queue);

    }

    // 雙端佇列
    @Test
    public void testDeque1() {

        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);
        System.out.println(deque);
        deque.offerLast(3); // 隊尾
        System.out.println(deque);
        deque.offerFirst(4); // 隊首
        System.out.println(deque); //[4,1,2,3]
        deque.offer(5);
        System.out.println(deque); // 等效於：offerLast

        Integer pollFirst = deque.pollFirst();// 隊首
        System.out.println(pollFirst);
        System.out.println(deque);
        Integer pollLast = deque.pollLast(); // 隊尾
        System.out.println(pollLast);
        System.out.println(deque);
        Integer poll = deque.poll();// 等效於：pollFirst
        System.out.println(poll);
        System.out.println(deque);

        Integer peekFirst = deque.peekFirst(); // 等效於：peek
        System.out.println(peekFirst);
        System.out.println(deque);
        Integer peekLast = deque.peekLast();
        System.out.println(peekLast);
        System.out.println(deque);

    }

    // 棧（先進後出）
    @Test
    public void testDeque2(){

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1); // 壓棧
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        Integer pop = stack.pop(); // 彈棧
        System.out.println(pop);
        System.out.println(stack);

        Integer peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack);

    }




}
