package pers.pengkk27.mybatislearn.repository.mapper2;

import pers.pengkk27.mybatislearn.repository.entity.Book;

import java.util.List;

/**
 * @author 14811
 * @date 2022/4/17
 */
public interface BookMapper {

    /**
     * 查询所有的List
     * @return bookList
     */
    List<Book> listBook();

    /**
     * 插入一本书
     * @param book 一本书的对象
     */
    void insertBook(Book book);
}
