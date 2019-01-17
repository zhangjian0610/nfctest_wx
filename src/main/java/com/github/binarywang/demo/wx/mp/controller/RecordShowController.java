package com.github.binarywang.demo.wx.mp.controller;


import com.github.binarywang.demo.wx.mp.Service.RecordShowService;
import com.github.binarywang.demo.wx.mp.model.RecordPage;
import com.github.binarywang.demo.wx.mp.model.bean.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/record")

public class RecordShowController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private RecordShowService recordShowService;

    @RequestMapping(value = "/fileInfo")
    public String fileinfo(String filename){
        request.setAttribute("fileName",filename);
        return "/info";
    }

    @RequestMapping(value = "/recordshow")
    @ResponseBody
    public List<RecordPage> showrecord(Record record){

        return recordShowService.recordshow(record);

    }
}
