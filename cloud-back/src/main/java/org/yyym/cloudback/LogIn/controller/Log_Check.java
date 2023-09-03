package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.LogIn.cclass.UserLogInput;
import org.yyym.cloudback.LogIn.service.CheckUserInputInfo;
import org.yyym.cloudback.general.Result;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class Log_Check {
    @Autowired
    private CheckUserInputInfo checkUserInputInfo;

    @RequestMapping("/LogIn/Check")
    public Result log_check(UserLogInput input) {
        return checkUserInputInfo.check(input);
    }
}
