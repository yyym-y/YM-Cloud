package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WriteForgetInfo {
    @Insert("INSERT INTO tem_user_info(user_name, e_mail, password, code) values(\"forget\", #{email}, #{password}, #{code})")
    void write(String email, String password, String code);
}
