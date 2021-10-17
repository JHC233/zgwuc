package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.ForumSort;
import com.ujiuye.prometion.pojo.ForumSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumSortMapper {
    long countByExample(ForumSortExample example);

    int deleteByExample(ForumSortExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ForumSort record);

    int insertSelective(ForumSort record);

    List<ForumSort> selectByExample(ForumSortExample example);

    ForumSort selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ForumSort record, @Param("example") ForumSortExample example);

    int updateByExample(@Param("record") ForumSort record, @Param("example") ForumSortExample example);

    int updateByPrimaryKeySelective(ForumSort record);

    int updateByPrimaryKey(ForumSort record);
}