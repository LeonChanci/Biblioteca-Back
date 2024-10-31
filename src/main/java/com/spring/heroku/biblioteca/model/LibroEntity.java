package com.spring.heroku.biblioteca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "libro")
@Getter
@Setter
@NoArgsConstructor
public class LibroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro", nullable = false)
    private Integer idLibro;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "categoria", nullable = false, length = 20)
    private String categoria;

    @Column(name = "autor", nullable = false, length = 20)
    private String autor;

    @Column(name = "ano", nullable = false, length = 4)
    private String ano;
}

