package com.techoidu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techoidu.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
