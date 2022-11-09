package com.company.Summativ2SerranoPatsy.repository;

import com.company.Summativ2SerranoPatsy.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorId (int authorId);
}
