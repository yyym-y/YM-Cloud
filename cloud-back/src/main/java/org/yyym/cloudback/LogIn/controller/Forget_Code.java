package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.LogIn.service.ForgetServeSecond;
import org.yyym.cloudback.general.Result;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class Forget_Code {
    @Autowired
    private ForgetServeSecond second;

    @RequestMapping("Forget/Code")
    public Result forget_code(String email, String password, String code) {
        return second.serve(email, password, code);
    }
}
