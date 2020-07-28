package com.example.friend_themselves.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.friend_themselves.entity.FriendArticle;

/**
 * (FriendArticle)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-27 08:56:11
 */
public interface FriendArticleDao extends BaseMapper<FriendArticle> {

    Page<FriendArticle> selectPageVo(Page<FriendArticle> page,String id);

    Page<FriendArticle> selectPageByFriendVo(Page<FriendArticle> page, String id);
}
