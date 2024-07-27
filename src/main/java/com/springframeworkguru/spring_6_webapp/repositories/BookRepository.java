package com.springframeworkguru.spring_6_webapp.repositories;

import com.springframeworkguru.spring_6_webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
