package org.yyym.cloudback.LogIn.service.ach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyym.cloudback.LogIn.dao.QueryEmail;
import org.yyym.cloudback.LogIn.dao.WriteForgetInfo;
import org.yyym.cloudback.general.CheckEmailForm;
import org.yyym.cloudback.general.Random;
import org.yyym.cloudback.general.Result;
import org.yyym.cloudback.general.SendEmail;

import java.util.Date;

@Service
public class ForgetServeFirst implements org.yyym.cloudback.LogIn.service.ForgetServeFirst {
    @Autowired
    private QueryEmail queryEmail;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private WriteForgetInfo writeForgetInfo;

    @Override
    public Result serve(String input, String password) {
        if(!CheckEmailForm.check(input))
            return Result.error("Email_Form_Error");
        Integer ID = queryEmail.query(input);
        if(ID == null)
            return Result.error("Email_No_Found_Error");
        String code = Random.generateName().substring(1,8);
        sendEmail.send(
                input, "找回密码",
                "找回密码：验证码为 " + code, new Date()
        );
        writeForgetInfo.write(input, password, code);
        return Result.success();
    }
}
