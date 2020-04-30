package com.xnote.client.user;

import com.xnote.client.module.login.service.LoginService;
import com.xnote.client.common.utils.login.UpdateforLoginUtils;
import com.xnote.client.module.user.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class loginTest {

    @Autowired
    private LoginService loginService;
    @Test
    public void getLoginUserByLoginName()
    {
        String loginName = "test";
        System.out.println("===================================================================================");
        User user = loginService.getLoginUserByLoginName(loginName);
        System.out.println(user.toString());
        System.out.println("===================================================================================");
    }
    @Test
    public void DigestPass()
    {
//        String password = DigestUtils.sha1Hex("1234567890");
        System.out.println("===================================================================================");
        String loginName = "test";

        User user = loginService.getLoginUserByLoginName(loginName);
        System.out.println(user.toString());

        User user1 = UpdateforLoginUtils.updateforLogin(user);
        System.out.println(user1.toString());

        System.out.println("===================================================================================");
    }
}
