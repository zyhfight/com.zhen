package com.springboot.demo.service;

import com.springboot.demo.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author : zyh
 * @date : 2018-09-15 下午10:01
 */
public interface BookService {

    /**
     * 获取所有 Book
     */
    List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    Book update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    Book delete(Long id);

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    Book findById(Long id);


    /**
     * 获取分页列表
     * @param pageable
     * @return
     */
    Page<Book> findByPage(Pageable pageable);
}
