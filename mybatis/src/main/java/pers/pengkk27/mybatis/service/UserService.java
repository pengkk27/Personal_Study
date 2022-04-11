package pers.pengkk27.mybatis.service;

import org.springframework.stereotype.Service;
import pers.pengkk27.mybatis.common.dao.entity.User;
import pers.pengkk27.mybatis.common.dao.repository.UserMapper;

import javax.annotation.Resource;

/**
 * @author 14811
 * @Data 2022/2/27
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

}
