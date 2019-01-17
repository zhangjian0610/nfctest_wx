package com.github.binarywang.demo.wx.mp.Service;

import com.github.binarywang.demo.wx.mp.model.RecordPage;
import com.github.binarywang.demo.wx.mp.model.bean.Record;

import java.util.List;

public interface RecordShowService {
    public List<RecordPage> recordshow(Record record);
}
