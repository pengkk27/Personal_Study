package pers.pengkk27.mybatislearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.pengkk27.mybatislearn.repository.entity.Book;
import pers.pengkk27.mybatislearn.repository.entity.User;
import pers.pengkk27.mybatislearn.repository.mapper.UserMapper;
import pers.pengkk27.mybatislearn.repository.mapper2.BookMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 14811
 * @date 2022/4/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    private Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void bookInsertTest() {
        Book book = new Book();
        book.setName("呼啸山庄");
        bookMapper.insertBook(book);
    }
    @Test
    public void listBook() {
        List<Book> books = bookMapper.listBook();
        for (Book book : books) {
           logger.info(book.toString());
        }
    }

    @Test
    public void listUser() {
        List<User> users = userMapper.listUser();
        for (User user : users) {
            logger.info(user.toString());
        }
    }

    @Test
    public void getUserById() {
        User userById = userMapper.getUserById(3);
        logger.info(userById.toString());
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        userMapper.insertUser(user);
    }

    @Test
    public void insertUserBatch() {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        userMapper.insertUserBatch(list);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(3);
        user.setName("user");
        user.setAge(20);
        userMapper.updateUser(user);
    }

    @Test
    public void deleteAllUser() {
        userMapper.deleteAllUser();
    }

    @Test
    public void deleteUserById() {
        userMapper.deleteUserById(7);
    }
}
