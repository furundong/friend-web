package com.example.friend_themselves.controller;

import com.example.friend_themselves.entity.FriendArticle;
import com.example.friend_themselves.entity.response.Result;
import com.example.friend_themselves.service.FriendArticleService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getData")
    public Result getData(String pageNum,String pageSize,String title){
        return friendArticleService.getData(pageNum,pageSize,title);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable String id){
        return friendArticleService.deleteById(id);
    }

    @GetMapping("getDataByLimit")
    public Result getDataByLimit(String origin,String limit,String id){
        return friendArticleService.getDataByLimit(origin,limit,id);
    }

}
