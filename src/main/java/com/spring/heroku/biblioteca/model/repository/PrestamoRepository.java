package com.spring.heroku.biblioteca.model.repository;

import com.spring.heroku.biblioteca.model.PrestamoEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PrestamoRepository extends ListCrudRepository<PrestamoEntity, Integer> {

}
