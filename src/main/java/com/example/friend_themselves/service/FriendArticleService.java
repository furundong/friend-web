package com.example.friend_themselves.service;

import com.example.friend_themselves.dao.FriendArticleDao;
import com.example.friend_themselves.entity.FriendArticle;
import com.example.friend_themselves.entity.response.Result;
import com.example.friend_themselves.entity.response.ResultCode;
import com.example.friend_themselves.utils.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (FriendArticle)表服务接口
 *
 * @author makejava
 * @since 2020-07-27 08:55:35
 */
@Service
public class FriendArticleService {

    @Resource
    FriendArticleDao friendArticleDao;

    @Value("${sessionid}")
    private String id;

    public Result add(FriendArticle friendArticle) {
        friendArticle.setId(IdWorker.genId());
        friendArticle.setFid(id);
        friendArticle.setTime(new Timestamp(new Date().getTime()));
        friendArticleDao.insert(friendArticle);
        return new Result(ResultCode.SUCCESS);
    }
}
