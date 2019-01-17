package com.github.binarywang.demo.wx.mp.Service;


import com.github.binarywang.demo.wx.mp.dao.RecordMapper;
import com.github.binarywang.demo.wx.mp.model.RecordPage;
import com.github.binarywang.demo.wx.mp.model.bean.Record;
import com.github.binarywang.demo.wx.mp.utils.RecordShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordShowServiceImpl implements RecordShowService {

    @Autowired
    RecordMapper recordDao;
    @Override
    public List<RecordPage> recordshow(Record record) {
        List<RecordPage> l=recordDao.dataGrid(record);
        RecordShow.recordshow(l);
        return l;
    }
}
