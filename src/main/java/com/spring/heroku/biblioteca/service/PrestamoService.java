package com.spring.heroku.biblioteca.service;

import com.spring.heroku.biblioteca.model.PrestamoEntity;
import com.spring.heroku.biblioteca.model.interfaces.PrestamoSummary;
import com.spring.heroku.biblioteca.model.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    //---------------GET-----------------//
    public List<PrestamoEntity> findAll(){
        return this.prestamoRepository.findAll();
    }

    public List<PrestamoSummary> findPrestamoSummary(){
        return this.prestamoRepository.findPrestamoSummary();
    }

    public PrestamoEntity get(int idPrestamo) {
        return this.prestamoRepository.findById(idPrestamo).orElse(null);
    }

    //---------------POST-----------------//
    public PrestamoEntity save(PrestamoEntity prestamoEntity){
        return this.prestamoRepository.save(prestamoEntity);
    }

    //--------------DELETE-------------------//
    public void delete(int idPrestamo){
        this.prestamoRepository.deleteById(idPrestamo);
    }

    //-------------VALIDATE---------------//
    public boolean exist(int idPrestamo){
        return this.prestamoRepository.existsById(idPrestamo);
    }
}