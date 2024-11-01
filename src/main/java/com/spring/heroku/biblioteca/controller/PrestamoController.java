package com.spring.heroku.biblioteca.controller;

import com.spring.heroku.biblioteca.model.PrestamoEntity;
import com.spring.heroku.biblioteca.model.interfaces.PrestamoSummary;
import com.spring.heroku.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    //---------------GET-----------------//
    @GetMapping
    public ResponseEntity<List<PrestamoEntity>> getAll(){
        return ResponseEntity.ok(this.prestamoService.findAll());
    }

    @GetMapping("/summary")
    public ResponseEntity<List<PrestamoSummary>> getSummary() {
        return new ResponseEntity<>(this.prestamoService.findPrestamoSummary(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoEntity> get(@PathVariable("id") int idPrestamo) {
        return new ResponseEntity<>(this.prestamoService.get(idPrestamo), HttpStatus.OK);
    }

    //---------------POST-----------------//
    @PostMapping
    public ResponseEntity<PrestamoEntity> add(@RequestBody PrestamoEntity prestamo){
        if (prestamo.getIdPrestamo() == null || !this.prestamoService.exist(prestamo.getIdPrestamo())){
            return new ResponseEntity<>(this.prestamoService.save(prestamo), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------PUT-------------------//
    @PutMapping
    public ResponseEntity<PrestamoEntity> update(@RequestBody PrestamoEntity prestamo){
        if (prestamo.getIdPrestamo() != null && this.prestamoService.exist(prestamo.getIdPrestamo())){
            return new ResponseEntity<>(this.prestamoService.save(prestamo), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------DELETE-------------------//
    @DeleteMapping("/{id}")
    public ResponseEntity<PrestamoEntity> delete(@PathVariable("id") int idPrestamo){
        if (this.prestamoService.exist(idPrestamo)) {
            this.prestamoService.delete(idPrestamo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
