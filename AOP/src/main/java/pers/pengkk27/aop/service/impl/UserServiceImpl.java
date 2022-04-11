package pers.pengkk27.aop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.pengkk27.aop.repository.entity.User;
import pers.pengkk27.aop.repository.mapper.UserMapper;
import pers.pengkk27.aop.service.UserService;

/**
 * @author 14811
 * @Data 2022/4/10
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
        LOGGER.info("插入的元素 {}", user.toString());
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteById(user);
        LOGGER.info("删除的元素 {}", user.toString());
    }
}
