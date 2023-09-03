package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;

@Mapper
public interface QueryRegisterInfo {
    @Select("@SELECT code from tem_user_info WHERE user_name = #{userName} && e_mail = #{email} && password = #{password} && code = #{code};")
    String query(RegisterSave input);
}
