package com.company.Summativ2SerranoPatsy.repository;

import com.company.Summativ2SerranoPatsy.models.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {
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
    public void addGetDeletePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Clltns");
        publisher.setCity("NewPort Beach");
        publisher.setStreet("123 Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92649");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("clltns@publishcolltns.com");
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

        publisherRepository.deleteById(publisher.getId());

        publisher1 = publisherRepository.findById(publisher.getId());

        assertFalse(publisher1.isPresent());
    }
    @Test
    public void getAllPublishers(){
        Publisher publisher = new Publisher();
        publisher.setName("Clltns");
        publisher.setCity("NewPort Beach");
        publisher.setStreet("123 Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92649");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("clltns@publishcolltns.com");
        publisherRepository.save(publisher);

        publisher = new Publisher();
        publisher.setName("PS Publish");
        publisher.setCity(" Irvine");
        publisher.setStreet("456 First St.");
        publisher.setState("CA");
        publisher.setPostalCode("92647");
        publisher.setPhone("134-256-9090");
        publisher.setEmail("ps@pspublish.com");
        publisherRepository.save(publisher);

        List<Publisher> publishersList = publisherRepository.findAll();
        assertEquals(publishersList.size(), 2);

    }

    @Test
    public void updatePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Clltns");
        publisher.setCity("NewPort Beach");
        publisher.setStreet("123 Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92649");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("clltns@publishcolltns.com");
        publisherRepository.save(publisher);

        publisher.setName("Collected Books");
        publisher.setCity("Newport Beach");
        publisher.setStreet("1234 S. Main St.");
        publisher.setState("CA");
        publisher.setPostalCode("92647");
        publisher.setPhone("124-765-2315");
        publisher.setEmail("collections@publishcollections.com");
        publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }
}
