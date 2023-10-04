package com.hamburger.hamburger.repo.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public abstract class SuperRepository<T extends Serializable>  {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    protected abstract String getRedisKey();

    public void putData(List<T> list) {
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();

        for (T item : list) {
            opsForList.rightPush(getRedisKey(), item);
        }
    }

    public List<T> getData() {
        List<Serializable> list = redisTemplate.opsForList().range(getRedisKey(), 0, -1);
        List<T> data = new ArrayList<>();
        for (Serializable serializable : list) {
            data.add((T) serializable);
        }
        return data;
    }

    public void deleteData() {
        redisTemplate.delete(getRedisKey());
    }
}
