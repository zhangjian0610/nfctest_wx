package com.github.binarywang.demo.wx.mp.model.bean;


import com.github.binarywang.demo.wx.mp.model.PageHelper;

public class RecordKey extends PageHelper {
    private Integer start;

    private String deviceId;

    private String fileName;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }
}
