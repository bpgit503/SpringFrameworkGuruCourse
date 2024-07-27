package com.springframeworkguru.spring_6_webapp.bootstrap;

import com.springframeworkguru.spring_6_webapp.domain.Author;
import com.springframeworkguru.spring_6_webapp.domain.Book;
import com.springframeworkguru.spring_6_webapp.domain.Publisher;
import com.springframeworkguru.spring_6_webapp.repositories.AuthorRepository;
import com.springframeworkguru.spring_6_webapp.repositories.BookRepository;
import com.springframeworkguru.spring_6_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Spring stereotype
public class BootstrapData implements CommandLineRunner { //an interface by sprintboot when it detects the interface it has the run method

    // best practise to declare componets as final
    //we want to work with these repositories
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisher;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisher) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) throws Exception {
    Author chris = new Author();
    chris.setFirstName("Chris");
    chris.setLastName("Voss");

    Book book = new Book();
    book.setTitle("Never split the difference");
    book.setIsbn("123456");

    Author chrisSaved = authorRepository.save(chris);
    Book bookSaved = bookRepository.save(book);

    Author rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johsnon");

    Book noEJB = new Book();
    book.setTitle("J2EE Development without EJB");
    book.setIsbn("65786852");

    Author rodSaved = authorRepository.save(rod);
    Book noEJBSaved = bookRepository.save(noEJB);

    chrisSaved.getBooks().add(bookSaved);
    rodSaved.getBooks().add(noEJBSaved);

    authorRepository.save(chrisSaved);
    authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        this.publisher.save(publisher);

        System.out.println("Publisher Count: " + this.publisher.count());

    }
}
