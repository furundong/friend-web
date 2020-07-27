package com.example.friend_themselves.controller;

import com.example.friend_themselves.entity.FriendArticle;
import com.example.friend_themselves.entity.response.Result;
import com.example.friend_themselves.service.FriendArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (FriendArticle)表控制层
 *
 * @author makejava
 * @since 2020-07-27 08:55:37
 */
@RestController
@RequestMapping("friendArticle")
public class FriendArticleController {
    /**
     * 服务对象
     */
    @Resource
    private FriendArticleService friendArticleService;

    @PostMapping
    public Result add(@RequestBody  FriendArticle friendArticle){
        return friendArticleService.add(friendArticle);
    }

}
