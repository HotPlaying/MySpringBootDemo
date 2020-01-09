package com.training.mysites.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/ue")
public class UEditorController {
    @GetMapping("editor")
    @ResponseBody
    public String editor(HttpServletRequest request, HttpServletResponse response) {
        // request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String rootPath = request.getServletContext().getRealPath("/");
        return new ActionEnter( request, rootPath ).exec();
    }
}
