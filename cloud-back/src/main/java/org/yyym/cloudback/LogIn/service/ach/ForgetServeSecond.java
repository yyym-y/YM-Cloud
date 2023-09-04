package org.yyym.cloudback.LogIn.service.ach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyym.cloudback.LogIn.dao.ChangeLogPassword;
import org.yyym.cloudback.LogIn.dao.DelForgetInfo;
import org.yyym.cloudback.LogIn.dao.QueryForgetInfo;
import org.yyym.cloudback.general.CheckEmailForm;
import org.yyym.cloudback.general.Result;

@Service
public class ForgetServeSecond implements org.yyym.cloudback.LogIn.service.ForgetServeSecond {
    @Autowired
    private QueryForgetInfo queryForgetInfo;

    @Autowired
    private DelForgetInfo delForgetInfo;

    @Autowired
    private ChangeLogPassword changeLogPassword;

    @Override
    public Result serve(String input, String password, String code) {
        if(!CheckEmailForm.check(input))
            return Result.error("Email_Form_Error");
        String code_ = queryForgetInfo.query(input, password, code);
        if(code_ == null)
            return Result.error("Code_Wrong_Error");
        delForgetInfo.del(input, password, code);
        changeLogPassword.update(input, password);
        return Result.success();
    }
}
