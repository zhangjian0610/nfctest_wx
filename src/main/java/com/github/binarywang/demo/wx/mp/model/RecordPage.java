package com.github.binarywang.demo.wx.mp.model;


import com.github.binarywang.demo.wx.mp.model.bean.Record;

public class RecordPage extends Record implements java.io.Serializable{

    private static final long serialVersionUID = -3529566878106140446L;
    private Integer last;
    private Integer interval;

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
