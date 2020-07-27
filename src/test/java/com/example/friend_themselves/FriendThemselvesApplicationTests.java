package com.example.friend_themselves;

import com.example.friend_themselves.dao.FriendListDao;
import com.example.friend_themselves.entity.FriendList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class FriendThemselvesApplicationTests {

    @Resource
    FriendListDao friendListDao;

    @Test
    void contextLoads() {
        List<FriendList> friendLists = friendListDao.selectList(null);
        friendLists.forEach(f-> System.out.println("f = " + f));
    }

}
