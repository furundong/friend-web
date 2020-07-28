package com.example.friend_themselves.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class FriendArticle {

  private String id;
  private String title;
  private String content;
  private java.sql.Timestamp time;
  private String fid;

  @TableField(exist = false)
  private FriendList friendList;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getFid() {
    return fid;
  }

  public void setFid(String fid) {
    this.fid = fid;
  }

}
