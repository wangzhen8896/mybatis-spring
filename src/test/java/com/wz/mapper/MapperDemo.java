package com.wz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MapperDemo {

  @Select("select * from Test")
  Object query();
}
