package com.demo.ant.controller;

import com.demo.ant.MybatisPlusApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/15 14:59
 * @description:
 */
@Component
public class UserControllerTest extends MybatisPlusApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
//        User user =new User("root","root");
//        session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    @Test
    public void all() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/selectpage")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

//    /**
//     * 新增教程测试用例
//     * @throws Exception
//     */
//    @Test
//    public void addLearn() throws Exception{
//        String json="{\"author\":\"HAHAHAA\",\"title\":\"Spring\",\"url\":\"http://tengj.top/\"}";
//        mvc.perform(MockMvcRequestBuilders.post("/learn/add")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(json.getBytes()) //传json参数
//                .session(session)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

//    /**
//     * 修改教程测试用例
//     * @throws Exception
//     */
//    @Test
//    public void updateLearn() throws Exception{
//        String json="{\"author\":\"测试修改\",\"id\":1031,\"title\":\"Spring Boot干货系列\",\"url\":\"http://tengj.top/\"}";
//        mvc.perform(MockMvcRequestBuilders.post("/learn/update")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(json.getBytes())//传json参数
//                .session(session)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 删除教程测试用例
//     * @throws Exception
//     */
//    @Test
//    public void deleteLearn() throws Exception{
//        String json="[1031]";
//        mvc.perform(MockMvcRequestBuilders.post("/learn/delete")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(json.getBytes())//传json参数
//                .session(session)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
}