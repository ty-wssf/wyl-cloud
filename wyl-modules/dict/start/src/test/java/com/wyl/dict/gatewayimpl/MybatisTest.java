package com.wyl.dict.gatewayimpl;

import com.wyl.Application;
import com.wyl.dict.gatewayimpl.database.SysDictTypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MybatisTest {

    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    @Test
    public void testSelect() {
        sysDictTypeMapper.selectByPrimaryKey(1L);
    }

}
