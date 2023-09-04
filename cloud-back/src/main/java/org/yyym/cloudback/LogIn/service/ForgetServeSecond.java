package org.yyym.cloudback.LogIn.service;

import org.yyym.cloudback.general.Result;

public interface ForgetServeSecond {
    Result serve(String input, String password, String code);
}
