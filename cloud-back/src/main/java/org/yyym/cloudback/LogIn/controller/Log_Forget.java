package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.LogIn.service.ForgetServeFirst;
import org.yyym.cloudback.general.Result;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class Log_Forget {
    @Autowired
    private ForgetServeFirst first;

    @RequestMapping("/LogIn/Forget")
    public Result forget(String email, String password) {
        System.out.println(email + " " + password);
        return first.serve(email, password);
    }
}
