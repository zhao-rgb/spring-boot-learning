package com.soft1851.springboot.aop.controller;

//@SpringBootTest
//@WebAppConfiguration
//class HelloControllerMVCTest {
//    //用于模拟调用Controller的接口发起请求
//    private MockMvc mockMvc;
//
//    //预加载内容，用来初始化对 HelloController的模拟
//    @BeforeEach
//    public void setUp() throws Exception{
//        mockMvc = MockMvcBuilders.standaloneSetup(new HelloControllerMVC()).build();
//    }
//
//    @Test
//    void hello() throws Exception {
//        /*
//         * 1、mockMvc.perform执行一个请求。
//         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
//         * 3、ResultActions.param添加请求传值
//         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
//         * 5、ResultActions.andExpect添加执行完成后的断言。
//         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
//         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
//         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
//         */
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/hello")
//                .param("name", "Tom")
//                .header("token","909090"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//}