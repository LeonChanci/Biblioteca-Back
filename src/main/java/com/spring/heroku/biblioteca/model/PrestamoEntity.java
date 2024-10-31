package com.spring.heroku.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "prestamo")
@Getter
@Setter
@NoArgsConstructor
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo", nullable = false)
    private Integer idPrestamo;

    @Column(name = "id_cliente", nullable = false, length = 15)
    private String idCliente;

    @Column(name = "id_libro", nullable = false)
    private Integer idLibro;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @JsonIgnore
    private ClienteEntity cliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    @JsonIgnore
    private LibroEntity raza;
}
