package org.yyym.cloudback.LogIn.service;

import org.yyym.cloudback.LogIn.cclass.UserLogInput;
import org.yyym.cloudback.general.Result;

public interface CheckUserInputInfo {
    Result check(UserLogInput userLogInput);
}
