package com.xj.blogs.handle;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.xj.blogs.mapper.UserMapper;
import com.xj.blogs.model.entity.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserHandle {

    private UserMapper userMapper;

    /**
     * 根据用户账号统计
     * @param userAccount 用户账号
     * @return 统计数量
     */
    public long countByAccount(String userAccount) {
        return new LambdaQueryChainWrapper<>(userMapper)
            .eq(User::getUserAccount, userAccount)
            .count();
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    /**
     * 根据账号查询用户
     * @param userAccount 账号
     * @return 用户信息
     */
    public User queryByUserAccount(String userAccount) {
        return new LambdaQueryChainWrapper<>(userMapper)
            .eq(User::getUserAccount, userAccount)
            .one();
    }

    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return 用户信息
     */
    public User queryById(Long userId) {
        return new LambdaQueryChainWrapper<>(userMapper)
            .eq(User::getId, userId)
            .one();
    }
}
