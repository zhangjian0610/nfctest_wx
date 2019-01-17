package com.github.binarywang.demo.wx.mp.controller;

import com.github.binarywang.demo.wx.mp.Service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @RequestMapping("/send")
    @ResponseBody
    public void send(String deviceId, String fileName, String openId,String uploadTime){
        templateService.sendTemplate(deviceId,fileName,uploadTime,openId);
    }
}
