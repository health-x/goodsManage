package com.health.pojo;

import java.io.Serializable;

public class Brand implements Serializable {
    private Integer bid;

    private String bname;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }
}