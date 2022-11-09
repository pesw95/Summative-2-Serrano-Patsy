package com.company.Summativ2SerranoPatsy.repository;

import com.company.Summativ2SerranoPatsy.models.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;


    @org.junit.Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void addGetDeleteAuthor(){
        Author author = new Author();
        author.setFirstName("Genesis");
        author.setLastName("Serrano");
        author.setStreet("54321 Broadway St");
        author.setCity("Huntington Beach");
        author.setState("CA");
        author.setPostalCode("92647");
        author.setPhone("980-765-4321");
        author.setEmail("Agenesis@gmail.com");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(),author);

        authorRepository.deleteById(author.getId());

        author1 = authorRepository.findById(author.getId());

        assertFalse(author1.isPresent());

    }

    @Test
    public void updateAuthor(){
        Author author = new Author();
        author.setFirstName("Genesis");
        author.setLastName("Serrano");
        author.setStreet("54321 Broadway St");
        author.setCity("Huntington Beach");
        author.setState("CA");
        author.setPostalCode("92647");
        author.setPhone("980-765-4321");
        author.setEmail("Agenesis@gmail.com");

        author = authorRepository.save(author);

//        author.setFirstName("Genesis");
//        author.setLastName("Harris");
        author.setStreet("3423 Main St");
        author.setCity("Rededodo Beach");
        author.setState("MN");
//        author.setPostalCode("92649");
//        author.setPhone("980-765-4321");
//        author.setEmail("Hgenesis@gmail.com");


        authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(),author);

    }
    @Test
    public void getAllAuthors(){
        Author author = new Author();
        author.setFirstName("Genesis");
        author.setLastName("Serrano");
        author.setStreet("54321 Broadway St");
        author.setCity("Huntington Beach");
        author.setState("CA");
        author.setPostalCode("92647");
        author.setPhone("980-765-4321");
        author.setEmail("Agenesis@gmail.com");

        author = authorRepository.save(author);

        author = new Author();
        author.setFirstName("Genesis");
        author.setLastName("Harris");
        author.setStreet("54321 Main St");
        author.setCity("Huntington Beach");
        author.setState("CA");
        author.setPostalCode("92649");
        author.setPhone("980-765-4321");
        author.setEmail("Hgenesis@gmail.com");

        author = authorRepository.save(author);

        List<Author> authors = authorRepository.findAll();

        assertEquals(authors.size(), 2);

    }
    @Test
    public void getAuthorByName(){
        Author author = new Author();
        author.setFirstName("Genesis");
        author.setLastName("Serrano");
        author.setStreet("54321 Broadway St");
        author.setCity("Huntington Beach");
        author.setState("CA");
        author.setPostalCode("92647");
        author.setPhone("980-765-4321");
        author.setEmail("Agenesis@gmail.com");

        author = authorRepository.save(author);

        author = new Author();
        author.setFirstName("Alondra");
        author.setLastName("Harris");
        author.setStreet("54321 Main St");
        author.setCity("Huntington Beach");
        author.setState("CA");
        author.setPostalCode("92649");
        author.setPhone("980-765-4321");
        author.setEmail("Hgenesis@gmail.com");

        author = authorRepository.save(author);

        List<Author> authors = authorRepository.findByFirstName("Genesis");

        assertEquals(authors.size(), 1);
    }



}