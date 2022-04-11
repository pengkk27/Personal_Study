package pers.pengkk27.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import pers.pengkk27.aop.repository.entity.User;

import javax.annotation.Resource;

/**
 * 用户操作切面
 *
 * @author yuepengk
 */
@Aspect
@Component
public class UserAop {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 在用户数据库插入信息之后，用户信息加入redis
     */
    @After(value = "execution(* pers.pengkk27.aop.service.impl.UserServiceImpl.addUser(*))")
    public void after(JoinPoint joinPoint){
        User user = (User) joinPoint.getArgs()[0];
        redisTemplate.opsForValue().set(user.getId(), user.getName());
    }

    /**
     * 在用户数据库删除信息之后，删除redis中用户信息
     */
    @After(value = "execution(* pers.pengkk27.aop.service.impl.UserServiceImpl.deleteUser(*))")
    public void deleteAfter(JoinPoint joinPoint) {
        User user = (User) joinPoint.getArgs()[0];
        redisTemplate.delete(user.getId());
    }
}
