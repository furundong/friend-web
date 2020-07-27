package com.example.friend_themselves.entity;

import lombok.Data;

@Data
public class FriendRelation {

  private String id;
  private String fid;
  private String fRid;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getFid() {
    return fid;
  }

  public void setFid(String fid) {
    this.fid = fid;
  }


  public String getFRid() {
    return fRid;
  }

  public void setFRid(String fRid) {
    this.fRid = fRid;
  }

}
