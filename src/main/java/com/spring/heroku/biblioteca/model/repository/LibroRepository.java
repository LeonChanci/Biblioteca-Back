package com.spring.heroku.biblioteca.model.repository;

import com.spring.heroku.biblioteca.model.LibroEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface LibroRepository extends ListCrudRepository<LibroEntity, Integer> {

}
