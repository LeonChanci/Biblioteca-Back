package com.spring.heroku.biblioteca.service;

import com.spring.heroku.biblioteca.model.LibroEntity;
import com.spring.heroku.biblioteca.model.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    //---------------GET-----------------//
    public List<LibroEntity> findAll(){
        return this.libroRepository.findAll();
    }

        public LibroEntity get(int idLibro) {
        return this.libroRepository.findById(idLibro).orElse(null);
    }

    //---------------POST-----------------//
    public LibroEntity save(LibroEntity libroEntity){
        return this.libroRepository.save(libroEntity);
    }

    //--------------DELETE-------------------//
    public void delete(int idLibro){
        this.libroRepository.deleteById(idLibro);
    }

    //-------------VALIDATE---------------//
    public boolean exist(int idLibro){
        return this.libroRepository.existsById(idLibro);
    }
}
