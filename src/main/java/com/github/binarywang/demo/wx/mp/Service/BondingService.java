package com.github.binarywang.demo.wx.mp.Service;

import com.github.binarywang.demo.wx.mp.model.Json;

public interface BondingService {
    public Json bonding(String username,String password,String openId) throws Exception;
}
