package com.training.mysites.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer uid;
    @Column(length=30,unique = true)
    @NotNull
    private String account;
    @Column(length=30)
    @NotNull
    private String password;
    @Column(length=30)
    private String name;
    public enum Sex{
        男, 女;   //枚举中常量结束位置要有分号
        public static List<String> toList() {
            Sex[] sex = Sex.values();
            List<String> datas = new ArrayList<>(); //定义一个列表容纳所有枚举数据
            for (Sex s : sex) {
                datas.add(s.name());
            }
            return datas;
        }

    }
    private Sex gender;
    private LocalDate birthday;
    @Column(length=11)
    private String phonenumber;
    @Column(length=100)
    private String email;
    private Integer lasttime;   //最后登陆时间
    private Integer logincount; //登陆时间
    private Integer valistate = 1;  //用户是否有效

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLasttime() {
        return lasttime;
    }

    public void setLasttime(Integer lasttime) {
        this.lasttime = lasttime;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Integer getValistate() {
        return valistate;
    }

    public void setValistate(Integer valistate) {
        this.valistate = valistate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(account, user.account) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                gender == user.gender &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(phonenumber, user.phonenumber) &&
                Objects.equals(email, user.email) &&
                Objects.equals(lasttime, user.lasttime) &&
                Objects.equals(logincount, user.logincount) &&
                Objects.equals(valistate, user.valistate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, account, password, name, gender, birthday, phonenumber, email, lasttime, logincount, valistate);
    }
}
