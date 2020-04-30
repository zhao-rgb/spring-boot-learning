package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.Follower;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class FollowerMapperTest {

    @Resource
    private FollowerMapper followerMapper;

    @Test
    void testSelectAll(){
        List<Follower> followers = followerMapper.selectList(null);
        followers.forEach(System.out::println);
    }

    @Test
    void testDelete(){
        int followers = followerMapper.deleteById("ba86e3572bd07ee3ecac7c32d1b578cb");
    }

    @Test
    void testInsert(){
        int n = followerMapper.insert(Follower.builder().id("123").name("hhaha").build());
        assertEquals(1,n);
    }

    @Test
    void updateById(){
        Follower follower = Follower.builder()
                .id("d9dfc648836eedd0d2fd3c6d695f8ff5")
                .name("小气鬼")
                .build();
        followerMapper.updateById(follower);
    }


    @Test
    void selectOne(){
        Follower followers = followerMapper.selectById("d9dfc648836eedd0d2fd3c6d695f8ff5");
        System.out.println(followers);
    }
}