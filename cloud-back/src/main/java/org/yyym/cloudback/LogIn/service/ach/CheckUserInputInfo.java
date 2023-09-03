package org.yyym.cloudback.LogIn.service.ach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyym.cloudback.LogIn.cclass.LogReturn;
import org.yyym.cloudback.LogIn.cclass.UserLogInput;
import org.yyym.cloudback.LogIn.dao.QueryUserIDByEmail;
import org.yyym.cloudback.LogIn.dao.QueryUserIDByUserName;
import org.yyym.cloudback.general.CheckEmailForm;
import org.yyym.cloudback.general.Jwt;
import org.yyym.cloudback.general.Result;

import java.util.HashMap;
import java.util.Map;

@Service
public class CheckUserInputInfo implements org.yyym.cloudback.LogIn.service.CheckUserInputInfo {
    @Autowired
    private QueryUserIDByUserName queryUserIDByUserName;

    @Autowired
    private QueryUserIDByEmail queryUserIDByEmail;

    @Override
    public Result check(UserLogInput userLogInput) {
        Integer ID;
        if (CheckEmailForm.check(userLogInput.getUID())) {
            ID = queryUserIDByEmail.query(userLogInput);
        }else {
            ID = queryUserIDByUserName.query(userLogInput);
        }
        if (ID == null)
            return Result.error("UID_OR_Password_Error");
        Map<String, Object> map = new HashMap<>();
        map.put("UID", userLogInput.getUID()); map.put("userID", ID);
        LogReturn result = new LogReturn(Jwt.getJwt(map, 30, "YM~Cloud--yyym"), ID);
        return Result.success(result);
    }
}
