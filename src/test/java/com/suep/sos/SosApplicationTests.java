package com.suep.sos;

import com.suep.sos.Service.Implementation.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SosApplicationTests {

    @Autowired
    UserServiceImp userService;

    @Test
    void contextLoads() {
        System.out.println(userService.get("admin", "123"));;
    }

}
