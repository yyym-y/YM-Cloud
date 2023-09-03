package org.yyym.cloudback.LogIn.service.ach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;
import org.yyym.cloudback.LogIn.dao.DelRegisterInfo;
import org.yyym.cloudback.LogIn.dao.QueryRegisterInfo;
import org.yyym.cloudback.LogIn.dao.WriteUserInfo;
import org.yyym.cloudback.general.Result;

@Service
public class RegisterServeSecond implements org.yyym.cloudback.LogIn.service.RegisterServeSecond {
    @Autowired
    private QueryRegisterInfo queryRegisterInfo;

    @Autowired
    private DelRegisterInfo delRegisterInfo;

    @Autowired
    private WriteUserInfo writeUserInfo;

    @Override
    public Result serve(RegisterSave input) {
        String code = queryRegisterInfo.query(input);
        if(code == null) return Result.error("Code_Wrong_Error");
        delRegisterInfo.del(input);
        writeUserInfo.write(input);
        return Result.success();
    }
}
