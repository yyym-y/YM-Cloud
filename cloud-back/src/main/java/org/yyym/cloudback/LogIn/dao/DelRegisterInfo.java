package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.yyym.cloudback.LogIn.cclass.RegisterSave;

@Mapper
public interface DelRegisterInfo {
    @Delete("DELETE from tem_user_info WHERE user_name = #{userName} && e_mail = #{email} && password = #{password} && code = #{code};")
    void del(RegisterSave input);
}
