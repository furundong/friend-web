package com.example.friend_themselves.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.friend_themselves.dao.FriendListDao;
import com.example.friend_themselves.dao.FriendRelationDao;
import com.example.friend_themselves.entity.FriendList;
import com.example.friend_themselves.entity.FriendRelation;
import com.example.friend_themselves.entity.response.PageResult;
import com.example.friend_themselves.entity.response.Result;
import com.example.friend_themselves.entity.response.ResultCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * (FriendList)表服务接口
 *
 * @author makejava
 * @since 2020-07-27 09:01:33
 */
@Service
public class FriendListService {

    @Resource
    FriendListDao friendListDao;

    @Resource
    FriendRelationDao friendRelationDao;

    @Value("${sessionid}")
    private String id;

    public Result changeSpace(String value) {
        FriendList friendList = new FriendList();
        friendList.setId(id);
        friendList.setSpace(Boolean.valueOf(value));
        friendListDao.updateById(friendList);
        return new Result(ResultCode.SUCCESS);
    }

    public Result getData(String pageNum, String pageSize, String title) {
        IPage<FriendList> iPage = new Page<>(Long.parseLong(pageNum), Long.parseLong(pageSize));
        QueryWrapper<FriendList> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            wrapper.like("name", title);
        }
        IPage<FriendList> list = friendListDao.selectPageRole(iPage, wrapper,this.id);
        return new Result(ResultCode.SUCCESS, new PageResult<>(list.getTotal(), list.getRecords()));
    }

    public Result deleteById(String id) {
        QueryWrapper<FriendRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("f_rid",id);
        wrapper.eq("fid",this.id);
        friendRelationDao.delete(wrapper);
        return new Result(ResultCode.SUCCESS);
    }
}
