package com.github.binarywang.demo.wx.mp.Service;

import com.github.binarywang.demo.wx.mp.config.WxMpConfiguration;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {

    static final String templateId="_moYrdbe4KIdzWofrLOrjr5Qm0pZleQHrUZoFd1IXZM";
    //static final String url="www.baidu.com";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sendTemplate(String deviceId, String fileName,String uploadTime, String openId) {

        String url="http://zhangjian.nat300.top/record/fileInfo?filename="+fileName;
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().
            toUser(openId).
            templateId(templateId)
            .url(url)
            .build();
        /*SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss.SSS");*/

        templateMessage.addData(new WxMpTemplateData("first", "您好，您的设备上传了一条新的测试文件", "#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword1", deviceId, "#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword2", fileName, "#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword3",uploadTime,"#173177"));
        templateMessage.addData(new WxMpTemplateData("remark", "请点击查看", "#173177"));



        Map<String, WxMpService> serviceMap= WxMpConfiguration.getMpServices();
        for (String appid:serviceMap.keySet()
             ) {

            try {
                serviceMap.get(appid).getTemplateMsgService().sendTemplateMsg(templateMessage);
            } catch (WxErrorException e) {
                e.printStackTrace();
                this.logger.error("模版信息发送失败");
            }
        }
    }
}
