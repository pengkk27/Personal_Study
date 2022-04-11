package pers.pengkk27.aop.service;

import pers.pengkk27.aop.repository.entity.User;

/**
 * 用户操作接口
 *
 * @author yuepeng
 */
public interface UserService {

    /**
     * 添加用户
     * @param user 用户实体
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param user 用户实体
     */
    void deleteUser(User user);
}
