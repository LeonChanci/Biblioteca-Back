package com.spring.heroku.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class ClienteEntity implements Serializable {

    @Id
    @Column(name = "id_cliente", nullable = false, length = 15)
    private String idCliente;

    @Column(name = "nombres", nullable = false, length = 60)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 60)
    private String apellidos;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "telefono", length = 20)
    private String telefono;
}
