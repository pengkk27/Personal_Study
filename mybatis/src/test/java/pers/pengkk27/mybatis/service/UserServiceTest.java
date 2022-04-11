package pers.pengkk27.mybatis.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.pengkk27.mybatis.MybatisApplication;
import pers.pengkk27.mybatis.common.dao.entity.User;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(MybatisApplication.class);

    @Resource
    private UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("xiaoxx");
        user.setName("小星星");
        user.setPassword("222222");
        user.setPhone("13890907676");
        userService.insertUser(user);

        User user1 = userService.findById(user.getId());
        assertThat(user1.getUsername(), is("xiaoxx"));
        assertThat(user1.getName(), is("小星星"));

        user1.setPassword("888888");
        userService.updateUser(user1);
        User user2 = userService.findById(user.getId());
        assertThat(user2.getPassword(), is("888888"));

        userService.deleteUser(user.getId());

        User user3 = userService.findById(user.getId());
        assertThat(user3, nullValue());

    }
}