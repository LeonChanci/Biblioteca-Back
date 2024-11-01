package com.spring.heroku.biblioteca.model.repository;

import com.spring.heroku.biblioteca.model.PrestamoEntity;
import com.spring.heroku.biblioteca.model.interfaces.PrestamoSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PrestamoRepository extends ListCrudRepository<PrestamoEntity, Integer> {
    @Query(value = "SELECT pre.id_prestamo AS idPrestamo, pre.fecha_inicio AS fechaInicio, pre.fecha_fin AS fechaFin," +
            "           cli.id_cliente AS idCliente, cli.nombres AS nombres, cli.apellidos AS apellidos," +
            "           cli.direccion AS direccion, cli.telefono AS telefono, cli.edad AS edad," +
            "           lib.id_libro AS idLibro, lib.nombre AS nombre, lib.descripcion AS descripcion," +
            "           lib.categoria AS categoria, lib.autor AS autor, lib.ano AS ano" +
            "       FROM prestamo pre " +
            "       INNER JOIN cliente cli ON cli.id_cliente = pre.id_cliente " +
            "       INNER JOIN libro lib ON lib.id_libro = pre.id_libro;", nativeQuery = true)
    List<PrestamoSummary> findPrestamoSummary();
}
