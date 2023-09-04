package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;

@Mapper
public interface WriteUserInfo {
    @Insert("INSERT INTO Log_info(user_name, e_mail, password) VALUES(#{userName}, #{email}, #{password})")
    void write(RegisterSave input);
}
