package com.spring.heroku.biblioteca.service;

import com.spring.heroku.biblioteca.model.ClienteEntity;
import com.spring.heroku.biblioteca.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //---------------GET-----------------//
    public List<ClienteEntity> findAll(){
        return this.clienteRepository.findAll();
    }

    public ClienteEntity getCliente(String idCliente) {
        return this.clienteRepository.findById(idCliente).orElse(null);
    }

    //---------------POST-----------------//
    public ClienteEntity save(ClienteEntity clienteEntity){
        return this.clienteRepository.save(clienteEntity);
    }

    //--------------DELETE-------------------//
    public void delete(String idCliente){
        this.clienteRepository.deleteById(idCliente);
    }

    //-------------VALIDATE---------------//
    public boolean exist(String idCliente){
        return this.clienteRepository.existsById(String.valueOf(idCliente));
    }
}