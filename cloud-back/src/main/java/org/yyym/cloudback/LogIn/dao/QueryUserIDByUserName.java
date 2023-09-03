package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.yyym.cloudback.LogIn.cclass.UserLogInput;

@Mapper
public interface QueryUserIDByUserName {
    @Select("SELECT id from Log_info WHERE user_name = #{ UID } && password = #{ password };")
    Integer query(UserLogInput input);
}
