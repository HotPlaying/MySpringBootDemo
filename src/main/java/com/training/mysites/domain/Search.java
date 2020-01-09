package com.training.mysites.domain;

import java.time.LocalDate;

public class Search {
    private String keyword; //搜索使用的关键字
    private LocalDate sdate;    //开始时间
    private LocalDate edate;    //结束时间

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public LocalDate getSdate() {
        return sdate;
    }

    public void setSdate(LocalDate sdate) {
        this.sdate = sdate;
    }

    public LocalDate getEdate() {
        return edate;
    }

    public void setEdate(LocalDate edate) {
        this.edate = edate;
    }
}
