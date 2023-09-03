package org.yyym.cloudback.LogIn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QueryUserName {
    @Select("SELECT id from Log_info WHERE user_name = #{name} ;")
    Integer query(String name);
}
