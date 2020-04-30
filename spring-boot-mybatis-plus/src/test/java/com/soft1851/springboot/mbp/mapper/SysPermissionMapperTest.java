package com.soft1851.springboot.mbp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysPermissionMapperTest {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Test
    void selectPermission() {
        System.out.println(sysPermissionMapper.selectPermission("1"));
    }
}