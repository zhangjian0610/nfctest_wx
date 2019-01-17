package com.github.binarywang.demo.wx.mp.dao;

import com.github.binarywang.demo.wx.mp.model.RecordPage;
import com.github.binarywang.demo.wx.mp.model.bean.Record;
import com.github.binarywang.demo.wx.mp.model.bean.RecordExample;
import com.github.binarywang.demo.wx.mp.model.bean.RecordKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(RecordKey key);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(RecordKey key);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    /**
     * 通过Record 查找文件下所有记录
     *
     * */
    List<RecordPage> dataGrid(Record record);

    /**
     * 通过Record 查找 统计数目
     *
     * */
    Long countDataGrid(Record record);
}
