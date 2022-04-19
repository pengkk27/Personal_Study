package pers.pengkk27.mybatislearn.repository.mapper;

import pers.pengkk27.mybatislearn.repository.entity.User;

import java.util.List;

/**
 * @author 14811
 * @date 2022/4/17
 */
public interface UserMapper {

    /**
     * 查询全部的User
     * @return 所有User列表
     */
    List<User> listUser();

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return User
     */
    User getUserById(Integer id);

    /**
     * 插入一个用户
     * @param user 要插入的user
     */
    void insertUser(User user);

    /**
     * 批量插入user
     * @param userList user列表
     */
    void insertUserBatch(List<User> userList);

    /**
     * 修改User信息
     * @param user 要修改的User
     */
    void updateUser(User user);

    /**
     * 删除全部的User
     */
    void deleteAllUser();

    /**
     * 根据用户id删除User
     * @param id 用户id
     */
    void deleteUserById(Integer id);
}
