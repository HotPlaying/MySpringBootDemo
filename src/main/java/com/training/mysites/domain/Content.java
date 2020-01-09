package com.training.mysites.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="contents")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    @NotNull
    private String title;
    private String timg;
    @Lob
    private String contents;
    @ManyToOne
    @JoinColumn(name = "tid")
    private ContentType type;
    private Integer visitcount;
    private LocalDateTime lastmodify;
    private Integer topflag;
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;
    private LocalDateTime cdate;
    private Integer weight;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimg() {
        return timg;
    }

    public void setTimg(String timg) {
        this.timg = timg;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    public Integer getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }

    public LocalDateTime getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(LocalDateTime lastmodify) {
        this.lastmodify = lastmodify;
    }

    public Integer getTopflag() {
        return topflag;
    }

    public void setTopflag(Integer topflag) {
        this.topflag = topflag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public void setCdate(LocalDateTime cdate) {
        this.cdate = cdate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(cid, content.cid) &&
                Objects.equals(title, content.title) &&
                Objects.equals(timg, content.timg) &&
                Objects.equals(type, content.type) &&
                Objects.equals(visitcount, content.visitcount) &&
                Objects.equals(lastmodify, content.lastmodify) &&
                Objects.equals(topflag, content.topflag) &&
                Objects.equals(user, content.user) &&
                Objects.equals(cdate, content.cdate) &&
                Objects.equals(weight, content.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, title, timg, contents, type, visitcount, lastmodify, topflag, user, cdate, weight);
    }
}
