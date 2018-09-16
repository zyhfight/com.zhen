package com.springboot.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : zyh
 * @date : 2018-09-15 下午9:57
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
