package com.qianfeng.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/spring-bean.xml"})//读取spring的配置文件
//注解，读取spring的配置文件

@Transactional // 启用事物
public class BaseTest {

}
