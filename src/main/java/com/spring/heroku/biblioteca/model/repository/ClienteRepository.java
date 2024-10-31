package com.spring.heroku.biblioteca.model.repository;

import com.spring.heroku.biblioteca.model.ClienteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends ListCrudRepository<ClienteEntity, String> {

    //@Query -> usando JPQL Obtener un cliente por medio de su número telefónico
    @Query(value = "SELECT cli FROM ClienteEntity cli WHERE cli.telefono = :idTelefono")
    ClienteEntity findByTelefono(@Param("idTelefono") String idTelefono);
}