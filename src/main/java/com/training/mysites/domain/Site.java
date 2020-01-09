package com.training.mysites.domain;

import javax.persistence.*;

@Entity
@Table(name="sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String title;
    private String skey;    //logo
    private String svalue;  //文件名
    private boolean webvisible;
    public enum ValueType{
        TEXT, HTML, IMAGE, BIGTEXT
    }
    private ValueType stype;    //值在界面上使用的控件类型

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getSvalue() {
        return svalue;
    }

    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }

    public boolean isWebvisible() {
        return webvisible;
    }

    public void setWebvisible(boolean webvisible) {
        this.webvisible = webvisible;
    }

    public ValueType getStype() {
        return stype;
    }

    public void setStype(ValueType stype) {
        this.stype = stype;
    }
}
