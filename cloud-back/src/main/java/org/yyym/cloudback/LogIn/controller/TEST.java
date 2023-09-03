package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.general.Result;
import org.yyym.cloudback.general.SendEmail;

import java.util.Date;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class TEST {
    @Autowired
    private SendEmail sendEmail;

    @RequestMapping("/Message")
    public Result test() {
        for(int temp = 1 ; temp < 10 ; temp++)
            sendEmail.send("2295957229@qq.com", "test", "xhx_sbbbbb", new Date());
        return Result.success();
    }
}
