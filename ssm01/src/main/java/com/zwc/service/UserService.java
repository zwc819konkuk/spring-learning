package com.zwc.service;

import com.zwc.pojo.User;

public interface UserService {
    User findUser(String uname, String password);
    /*
    * SQLSession.getMapper()
    *
    * 在service层注入Mapper对象【MyBatis生成】
    *
    * sqlSessionFactory SqlSession **Mapper 全部交给Spring创建
    * 在Spring容器中存储**Mapper，再向service注入
    * */
}
