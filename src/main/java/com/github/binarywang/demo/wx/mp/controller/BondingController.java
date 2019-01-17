package com.github.binarywang.demo.wx.mp.controller;


import com.github.binarywang.demo.wx.mp.Service.BondingService;
import com.github.binarywang.demo.wx.mp.model.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bonding")
public class BondingController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    private BondingService bondingService;


    @RequestMapping("/bondpage")
    public String home(String openId){
        request.setAttribute("openId",openId);

        //此处返回绑定页面
        return "/bind";

    }

    @RequestMapping(value = "/bond",method = RequestMethod.POST)
    @ResponseBody
    public Json bongding(String username,String password,String openId)throws Exception{
        Json j = new Json();
        j=bondingService.bonding(username,password,openId);
        return j;
    }
}
