package org.qin.com.stock;

import org.junit.jupiter.api.Test;
import org.qin.com.stock.entity.SysUser;
import org.qin.com.stock.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class StockApplicationTests {
    @Autowired
    SysUserService sysUserService;

    @Test
    void contextLoads() {
    }
    @Test
    void pageQueryTest() {
        SysUser sysUser = new SysUser();
        System.out.println(sysUserService.queryByPage(sysUser,PageRequest.of(1,5)));
    }

}
