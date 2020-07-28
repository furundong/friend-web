package com.example.friend_themselves.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.friend_themselves.dao.FriendArticleDao;
import com.example.friend_themselves.entity.FriendArticle;
import com.example.friend_themselves.entity.response.PageResult;
import com.example.friend_themselves.entity.response.Result;
import com.example.friend_themselves.entity.response.ResultCode;
import com.example.friend_themselves.utils.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public Result getData(String pageNum, String pageSize, String title) {
        IPage<FriendArticle> iPage = new Page<>(Long.parseLong(pageNum), Long.parseLong(pageSize));
        QueryWrapper<FriendArticle> wrapper = new QueryWrapper<>();
        wrapper.eq("fid", id);
        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        IPage<FriendArticle> list = friendArticleDao.selectPage(iPage, wrapper);
        return new Result(ResultCode.SUCCESS, new PageResult<>(list.getTotal(), list.getRecords()));
    }

    public Result deleteById(String id) {
        friendArticleDao.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }


    public Result getDataByLimit(String origin, String limit, String id) {
        Page<FriendArticle> page = new Page<>(Long.parseLong(origin), Long.parseLong(limit));
        Page<FriendArticle> list;
        if (StringUtils.isEmpty(id) || id.equals("0")) {
            //查询所有好友跟自己的空间动态。
            list = friendArticleDao.selectPageVo(page, this.id);
        } else {
            //查询指定好友空间
            list = friendArticleDao.selectPageByFriendVo(page, id);
        }
        return new Result(ResultCode.SUCCESS, new PageResult<>(list.getTotal(), list.getRecords()));
    }

}
