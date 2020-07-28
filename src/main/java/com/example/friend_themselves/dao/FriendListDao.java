package com.example.friend_themselves.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.friend_themselves.entity.FriendList;

/**
 * (FriendList)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-27 09:01:33
 */
public interface FriendListDao extends BaseMapper<FriendList> {

    IPage<FriendList> selectPageRole(IPage<FriendList> iPage, QueryWrapper<FriendList> wrapper, String id);
}
