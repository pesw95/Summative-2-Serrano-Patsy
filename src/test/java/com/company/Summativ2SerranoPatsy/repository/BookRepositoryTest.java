package com.company.Summativ2SerranoPatsy.repository;

import com.company.Summativ2SerranoPatsy.models.Author;
import com.company.Summativ2SerranoPatsy.models.Book;
import com.company.Summativ2SerranoPatsy.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {
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
    public void addGetDeleteBook() {

        // Need to create a publisher and an Author first
        Publisher publisher = new Publisher();
        publisher.setName("Clltns");
        publisher.setCity("NewPort Beach");
        publisher.setStreet("123 Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92649");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("clltns@publishcolltns.com");
        publisher = publisherRepository.save(publisher);

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

        Book book = new Book();
        book.setIsbn("123-456-7890");
        book.setTitle("What if I...");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2020, 5, 15));
        book.setPrice(new BigDecimal("25.95"));

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);

        bookRepository.deleteById(book.getId());

        book1 = bookRepository.findById(book.getId());

        assertFalse(book1.isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException(){
        Book book = new Book();
        book.setIsbn("567-2323-66856-54");
        book.setAuthorId(3);
        book.setPublisherId(5);
        book.setPublishDate(LocalDate.of(2019,3,19));
        book.setPrice(new BigDecimal("25.00"));

        book = bookRepository.save(book);
    }

    @Test
    public void getAllBooks(){
        // Need to create a publisher and an Author first
        Publisher publisher = new Publisher();
        publisher.setName("Clltns");
        publisher.setCity("NewPort Beach");
        publisher.setStreet("123 Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92649");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("clltns@publishcolltns.com");
        publisher = publisherRepository.save(publisher);

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

        Book book = new Book();
        book.setIsbn("123-456-7890");
        book.setTitle("What if I...");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2020, 5, 15));
        book.setPrice(new BigDecimal("25.95"));

        book = bookRepository.save(book);

        List<Book> bookList = bookRepository.findAll();

        assertEquals(bookList.size(), 1);
    }

    @Test
    public void getBookByAuthor(){
        Publisher publisher = new Publisher();
        publisher.setName("Clltns");
        publisher.setCity("NewPort Beach");
        publisher.setStreet("123 Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92649");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("clltns@publishcolltns.com");
        publisher = publisherRepository.save(publisher);

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

        Book book = new Book();
        book.setIsbn("12345678");
        book.setTitle("What if I...");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2020, 5, 15));
        book.setPrice(new BigDecimal("25.95"));

        book = bookRepository.save(book);

        book = new Book();
        book.setIsbn("123-456-7890");
        book.setTitle("What Tomorrow Brings");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2019,7,24));
        book.setPrice(new BigDecimal("27.00"));

        book = bookRepository.save(book);

        List<Book> bookList = bookRepository.findByAuthorId(book.getAuthorId());
        assertEquals(bookList.size(),2);
    }



}