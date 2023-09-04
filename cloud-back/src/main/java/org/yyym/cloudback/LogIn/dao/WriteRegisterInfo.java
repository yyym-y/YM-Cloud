package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;

@Mapper
public interface WriteRegisterInfo {
    @Insert("INSERT INTO tem_user_info(user_name, e_mail, password, code) values(#{userName}, #{email}, #{password}, #{code})")
    void write(RegisterSave input);
}
