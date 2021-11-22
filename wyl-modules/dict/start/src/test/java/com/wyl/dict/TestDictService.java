package com.wyl.dict;

import com.wyl.DictApplication;
import com.wyl.api.IDictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wyl
 * @since 2021-11-22 14:58:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DictApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDictService {

    @Autowired
    private IDictService dictService;

    @Test
    public void testSelectDictTypeById() {
        dictService.selectDictTypeById(1L);
    }

}
