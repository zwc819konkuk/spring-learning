package com.zwc.dao;

public interface UserDao {
    //每一个切点cut point都是连接点joint point
    int addUser(int userId, String userName);
//    int updateUser(int userId, String userName);
//    int removeUser(int userId, String userName);
//    int findUser(int userId, String userName);
}
