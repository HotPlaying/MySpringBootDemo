package com.training.mysites.controller;

import com.training.mysites.domain.ContentType;
import com.training.mysites.service.ContentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ContentTypeController {
    @Autowired
    private ContentTypeService contentTypeService;
    @GetMapping({"/edittype", "/edittype/{tid}"})
    public String edit(@PathVariable(name = "tid", required = false)Integer tid, Model model) {
        ContentType type = null;
        if (tid==null) {
            type = new ContentType();
        } else {
            type = contentTypeService.findById(tid);
        }
        model.addAttribute("parents", contentTypeService.findByParent(null));
        model.addAttribute("contentType", type);
        return "edittype";
    }
    @PostMapping("/savetype")
    public String save(@Valid ContentType type, BindingResult result, Model model) {
        model.addAttribute("contentType", type);
        if (result.hasErrors()) {
            //在界面处理错误消息显示
        }
        contentTypeService.save(type);
        model.addAttribute("ok", "保存成功！");
        return "redirect:/edittype/" + type.getTid();
    }
    @GetMapping("/deletetype/{tid}")
    public String delete(@PathVariable("tid")Integer tid, Model model) {
        contentTypeService.deleteById(tid);
        model.addAttribute("ok", "删除成功");
        return "redirect:/edittype";
    }
}
