package com.wyl.dict;

import com.wyl.DictApplication;
import com.wyl.domain.gateway.DictGateway;
import com.wyl.gatewayimpl.database.dataobject.SysDictType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wyl
 * @since 2021-11-22 11:48:12
 */
@SpringBootTest(classes = DictApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDictGateway {

    @Autowired
    private DictGateway dictGateway;

    @Test
    public void testPageSelectDictTypeList() {
        dictGateway.pageSelectDictTypeList(new SysDictType());
    }

    @Test
    public void testSelectDictTypeById() {
        dictGateway.selectDictTypeById(1L);
    }

}
