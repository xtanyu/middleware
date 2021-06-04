package com.xtyu.demo;

import com.xtyu.demo.mapper.InfoMapper;
import com.xtyu.demo.pojo.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingJdbcDomeApplicationTests {

    @Autowired
    InfoMapper mapper;

    @Test
    void contextLoads() {
        for (int i = 0; i < 50; i++) {
            Info info =new Info();
            info.setName("测试");
            info.setAge(18);
            mapper.insert(info);
        }
    }

}
