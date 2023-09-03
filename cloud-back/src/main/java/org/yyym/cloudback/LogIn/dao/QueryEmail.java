package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QueryEmail {
    @Select("SELECT id from Log_info WHERE e_mail = #{Email};")
    Integer query(String Email);
}
