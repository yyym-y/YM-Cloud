package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DelForgetInfo {
    @Delete("DELETE from tem_user_info WHERE user_name = \"forget\" && e_mail = #{email} && password = #{password} && code = #{code};")
    void del(String email, String password, String code);
}
