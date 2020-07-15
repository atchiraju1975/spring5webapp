package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData
            (AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        System.out.println("inside bootstrap run");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Learning Spring", "123123");
        Publisher mcgrahill = new Publisher("McGrahill","People Tree Lane","London","Sussex","22025");

        publisherRepository.save(mcgrahill);
        System.out.println("Total no of publishers=" + publisherRepository.count());

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(mcgrahill);
        mcgrahill.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(mcgrahill);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("j2ee develoment with out EJB", "124124");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(mcgrahill);
        mcgrahill.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(mcgrahill);

        System.out.println("Total no of Books=" + bookRepository.count());
        System.out.println("Total Books published by publisher " + mcgrahill.getName() +" is "+ mcgrahill.getBooks().size());

        System.out.println("inside bootstrap end of method");

    }

}
