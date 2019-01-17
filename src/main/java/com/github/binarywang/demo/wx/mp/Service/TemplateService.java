package com.github.binarywang.demo.wx.mp.Service;



import java.util.Date;


public interface TemplateService {

    public void sendTemplate(String deviceId, String fileName,String uploadTime,String openID);
}
