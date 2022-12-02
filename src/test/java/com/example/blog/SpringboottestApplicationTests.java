package com.example.blog;


import com.example.blog.entity.User;
import com.example.blog.util.ElasticUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;


@SpringBootTest
class SpringboottestApplicationTests {

    @Resource
    ElasticUtil elasticUtil;

    @Test
    void contextLoads() throws IOException {
        User user = new User();
        user.setId(1);
        user.setName("yuba");
        user.setPassword("2020444263");
//
//        elasticUtil.create("user_db");e
//        elasticUtil.insertDoc(user);
//        elasticUtil.batchAddDoc();
//        elasticUtil.queryAllDoc();
//          elasticUtil.fuzzQueryDoc();

        elasticUtil.highlightQuery();
    }

}
