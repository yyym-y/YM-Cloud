package org.yyym.cloudback.LogIn.service.ach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyym.cloudback.LogIn.cclass.RegisterInput;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;
import org.yyym.cloudback.LogIn.dao.QueryEmail;
import org.yyym.cloudback.LogIn.dao.QueryUserName;
import org.yyym.cloudback.LogIn.dao.WriteRegisterInfo;
import org.yyym.cloudback.general.CheckEmailForm;
import org.yyym.cloudback.general.Random;
import org.yyym.cloudback.general.Result;
import org.yyym.cloudback.general.SendEmail;

import java.util.Date;

@Service
public class RegisterServeFirst implements org.yyym.cloudback.LogIn.service.RegisterServeFirst {
    @Autowired
    private QueryUserName queryUserName;

    @Autowired
    private QueryEmail queryEmail;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private WriteRegisterInfo writeRegisterInfo;
    @Override
    public Result serve(RegisterInput input) {
        Integer ID = queryUserName.query(input.getUserName());
        if (ID != null)
            return Result.error("UserName_Same_Error");
        if (!CheckEmailForm.check(input.getEmail()))
            return Result.error("Email_Form_Error");
        ID = queryEmail.query(input.getEmail());
        if (ID != null)
            return Result.error("Email_Same_Error");
        String code = Random.generateName().substring(1,8);
        RegisterSave tem = new RegisterSave(
                input.getUserName(), input.getEmail(),
                input.getPassword(), code
        );
        System.out.println(tem);
        writeRegisterInfo.write(tem);
        sendEmail.send(input.getEmail(), "YM-Cloud验证码验证",
                "欢迎使用YM~Cloud服务， 您的验证码是 " + code, new Date());
        return Result.success();
//        2295957229@qq.com
    }

}
