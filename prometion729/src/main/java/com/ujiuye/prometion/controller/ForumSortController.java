package com.ujiuye.prometion.controller;

import com.ujiuye.prometion.pojo.ForumSort;
import com.ujiuye.prometion.service.ForumSortServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/forumsort")
public class ForumSortController {

    @Autowired
    private ForumSortServcie forumSortServcie;

     @RequestMapping("/list")
    @ResponseBody
    public List<ForumSort> list(){
        List<ForumSort> list = forumSortServcie.list();
        return list;
    }
}
