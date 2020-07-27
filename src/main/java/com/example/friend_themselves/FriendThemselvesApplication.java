package com.example.friend_themselves;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.friend_themselves.dao")
public class FriendThemselvesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendThemselvesApplication.class, args);
    }

}
