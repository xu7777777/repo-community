package com.xqy.cool.cool.service;

import com.xqy.cool.cool.Mapper.UserMapper;
import com.xqy.cool.cool.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by codedrinker on 2019/5/23.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
//        UserExample userExample = new UserExample();
//        userExample.createCriteria()
//                .andAccountIdEqualTo(user.getAccountId());
//        List<User> users = userMapper.selectByExample(userExample);
//        if (users.size() == 0) {
//            // 插入
//            user.setGmtCreate(System.currentTimeMillis());
//            user.setGmtModified(user.getGmtCreate());
//            userMapper.insert(user);
//        } else {
//            //更新
//            User dbUser = users.get(0);
//            User updateUser = new User();
//            updateUser.setGmtModified(System.currentTimeMillis());
//            updateUser.setAvatarUrl(user.getAvatarUrl());
//            updateUser.setName(user.getName());
//            updateUser.setToken(user.getToken());
//            UserExample example = new UserExample();
//            example.createCriteria()
//                    .andIdEqualTo(dbUser.getId());
//            userMapper.updateByExampleSelective(updateUser, example);
//        }
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser == null){
            //插入
            user.setGmtCreate(System.currentTimeMillis());//当update时不用创建时间
            user.setGmtModify(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            //更新
            dbUser.setGmtModify(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }
    }
}
