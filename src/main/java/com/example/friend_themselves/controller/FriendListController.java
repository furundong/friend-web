package com.example.friend_themselves.controller;

import com.example.friend_themselves.entity.response.Result;
import com.example.friend_themselves.service.FriendListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (FriendList)表控制层
 *
 * @author makejava
 * @since 2020-07-27 09:01:34
 */
@RestController
@RequestMapping("friendList")
public class FriendListController {

    @Resource
    FriendListService friendListService;

    @GetMapping("changeSpace")
    public Result changeSpace(String value){
        return friendListService.changeSpace(value);
    }

    @GetMapping("getData")
    public Result getData(String pageNum,String pageSize,String title){
        return friendListService.getData(pageNum,pageSize,title);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable String id){
        return friendListService.deleteById(id);
    }
}
