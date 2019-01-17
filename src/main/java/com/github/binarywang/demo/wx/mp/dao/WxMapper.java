package com.github.binarywang.demo.wx.mp.dao;


import com.github.binarywang.demo.wx.mp.model.bean.WxBean;

import java.util.List;

public interface WxMapper {


    /**
     * 通过设备ID查找所有拥有此设备而且绑定了微信公众号的用户及相应的openId
     * */
    public List<WxBean> selectOpenIds(String deviceId);



    /**
     *
     * 通过admin_id查找此账号绑定的所有openid
     * */
    public List<WxBean> selectByadminId(String adminId);

    /**
     * 插入一条新的绑定记录
     * */
    public int insertWxBean(WxBean wxBean);

    /**
     * 通过openId查找所有绑定记录
     * */
    public List<WxBean> selectByOpenId(String openId);


    /**
     * 通过openId删除所有绑定记录
     * */
    public int delectByOpenId(String openId);
}
