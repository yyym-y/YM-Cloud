package org.yyym.cloudback.LogIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyym.cloudback.LogIn.cclass.RegisterInput;
import org.yyym.cloudback.LogIn.service.RegisterServeFirst;
import org.yyym.cloudback.general.Result;

@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@RestController
public class Register {
    @Autowired
    private RegisterServeFirst first;

    @RequestMapping("/Register")
    public Result register(RegisterInput input) {
        return first.serve(input);
    }
}
