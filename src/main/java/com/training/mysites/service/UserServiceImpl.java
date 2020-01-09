package com.training.mysites.service;

import com.training.mysites.dao.UserRepository;
import com.training.mysites.domain.User;
import com.training.mysites.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User u) throws Exception{
        try {
            userRepository.save(u);
        }catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Page<User> findAll(String kw, Pageable pageable) {
        return userRepository.findByKeyword(kw, pageable);
    }

    @Override
    public User findById(Integer uid) {
        return userRepository.findById(uid).get();
    }

    @Override
    public void delete(User u) {
        userRepository.delete(u);
    }

    @Override
    public void deleteById(Integer uid) {
        userRepository.deleteById(uid);
    }

    @Transactional
    @Override
    public void deletes(List<User> users) {
        for (User u: users) {
            userRepository.delete(u);
        }
    }

    /**
     * 检测登录用户是否为合法用户
     * @param user 用户
     * @return 是否通过
     */
    @Override
    public User checkUser(UserLogin user) {
        User u = null;
        //去数据库中通过账号查找用户信息
        Optional<User> ou = userRepository.findByAccount(user.getAccount());
        if (ou.isPresent()) {   //isPresent()方法判断Optional中是否包含目标对象
            u = ou.get();
            //把库中的密码与登陆时的密码比对是否一致
            if (u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }
        return null;   //其他一切返回null对象
    }
}
