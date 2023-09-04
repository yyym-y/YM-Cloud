package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ChangeLogPassword {
    @Update("UPDATE Log_info set password = #{password} WHERE e_mail = #{email};")
    void update(String email, String password);
}
