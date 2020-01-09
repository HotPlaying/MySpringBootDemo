package com.training.mysites.service;

import com.training.mysites.domain.User;
import com.training.mysites.domain.UserLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public void save(User u) throws Exception;
    public Page<User> findAll(String kw, Pageable pageable);
    public User findById(Integer uid);
    public void delete(User u);
    public void deleteById(Integer uid);
    public void deletes(List<User> users);
    public User checkUser(UserLogin user);   //修改方法，一定先去修改文档
}
