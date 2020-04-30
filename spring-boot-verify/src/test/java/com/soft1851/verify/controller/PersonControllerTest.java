package com.soft1851.verify.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft1851.verify.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void savePerson() throws Exception{
        //创建对象
        Person person = new Person();
        person.setId("123456");
        person.setName("Soft1851");
        person.setAge(20);
        person.setPhone("18851860805");
        person.setEmail("Soth1851@qq.com");
        person.setSex("Man");
        //创建请求，包括url、请求类型、内容（使用ObjectMapper简化繁琐的JSON串拼接）
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(person));
        //mockMvc执行请求，判断结果是否匹配
        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getPersonById() throws Exception{
        //路径参数不需要设置内容，类型选text/plain
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/person/1122") //id长度不够
                .contentType(MediaType.TEXT_PLAIN);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonById.id:id不能小于6位"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getPersonByName() throws Exception{
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .param("name","soft18511861"); //name长度超出范围

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonByName.name:name长度超出范围"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}