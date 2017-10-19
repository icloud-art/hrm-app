package com.charles.hrm.domain;

import java.io.Serializable;

public class Dept implements Serializable {

    private Integer id;
    private String name;
    private String remark;

    public Dept(){
        super();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
