package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface QueryForgetInfo {
    @Select("SELECT code from tem_user_info WHERE user_name = \"forget\" && e_mail = #{email} && password = #{password} && code = #{code};")
    String query(String email, String password, String code);
}
