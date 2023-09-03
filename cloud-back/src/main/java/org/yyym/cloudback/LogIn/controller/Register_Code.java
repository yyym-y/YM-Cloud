package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;
import org.yyym.cloudback.LogIn.service.RegisterServeSecond;
import org.yyym.cloudback.general.Result;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class Register_Code {
    @Autowired
    private RegisterServeSecond second;

    @RequestMapping("/Register/Code")
    public Result register_code(RegisterSave input) {
        return second.serve(input);
    }
}
