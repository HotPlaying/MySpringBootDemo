package com.training.mysites.dao;

import com.training.mysites.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where account like ?1 or name like ?1 or phonenumber like ?1 or email like ?1")
    public Page<User> findByKeyword(String kw, Pageable pageable);

    @Query("update User u set u.password=?1 where u.uid=?2")
    public void modifyPassword(String pwd, Integer uid);

    //通过账号查询用户信息，获取唯一的用户
    public Optional<User> findByAccount(String account);
}
