package com.wyl.dict;

import com.wyl.DictApplication;
import com.wyl.api.IDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wyl
 * @since 2021-11-22 14:58:17
 */
@SpringBootTest(classes = DictApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDictService {

    @Autowired
    private IDictService dictService;

    @Test
    public void testSelectDictTypeById() {
        dictService.selectDictTypeById(1L);
    }

}
