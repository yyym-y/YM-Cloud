package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;
import org.yyym.cloudback.LogIn.dao.WriteRegisterInfo;
import org.yyym.cloudback.LogIn.dao.WriteUserInfo;
import org.yyym.cloudback.general.Result;
import org.yyym.cloudback.general.SendEmail;

import java.util.Date;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class TEST {
    @Autowired
    private WriteUserInfo writeUserInfo;

    @RequestMapping("/test")
    public Result test() {
        return Result.success();
    }
}
