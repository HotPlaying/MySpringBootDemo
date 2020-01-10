package com.training.mysites.controller;

import com.training.mysites.domain.User;
import com.training.mysites.domain.UserLogin;
import com.training.mysites.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 登陆的实现
 * 1.用户输入账号密码，并提交
 * 2.控制器获得账号密码，去数据库中比对查找对应用户信息
 * 3.如果用户正确转向主界面，否则回到登录界面并提示错误
 * 为了实现登录
 * 1.定义一个JavaBean：UserLogin用来存储登陆时的用户名和密码，分开实体User的验证和登录验证
 * 2.在DAO访问中添加通过account查询用户信息的方法，service也要添加
 * 操作权限的处理：
 * 1.用户--》角色--》功能--》资源，spring security
 * 2.当用户登录成功后，每次访问操作资源（功能），验证用户是否登录，如果登陆了可访问否则不可访问，
 * 通过session中保存的user对象来判断
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    /**
     * Get请求返回登录表单
     * @return
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLogin user, BindingResult result, HttpSession session, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        //检查用户身份的方法
        User u = userService.checkUser(user);
        if(u != null) { //判断用户是否存在
            session.setAttribute("user", u);
            return "index";//管理主界面
        }
        attr.addFlashAttribute("fail", "账号或密码不正确");
        return "redirect:/login";
    }
    @GetMapping("/exit")
    public String exit(HttpSession session) {  //退出登录
        User u = null;
        session.setAttribute("user", u);
        return "redirect:/login";
    }
}
