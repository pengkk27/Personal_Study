package pers.pengkk27.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.pengkk27.redis.common.dao.entity.User;
import pers.pengkk27.redis.common.dao.repository.UserMapper;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 14811
 * @Data 2022/2/28
 */
@Service
@Transactional
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    public void createUser(User user) {
        logger.info("创建用户start...");
        userMapper.insert(user);
    }

    public User getById(int id) {
        logger.info("获取用户信息...");
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            logger.info("从缓存中获取了用户id = " + id);
            return user;
        }

        User user = userMapper.selectById(id);

        operations.set(key, user, 10, TimeUnit.SECONDS);

        return user;
    }

    public void updateUser(User user) {
        logger.info("更新用户start...");
        userMapper.updateById(user);
        int userId= user.getId();

        String key =  "user_" + userId;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时候，从缓存中删除用户 >> " + userId);
        }
    }

    public void deleteById(int id) {
        logger.info("删除用户start...");
        userMapper.deleteById(id);

        String key = "user_" + id;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时候，从缓存中删除用户 >> " + id);
        }
    }
}
