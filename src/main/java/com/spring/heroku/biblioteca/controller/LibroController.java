package com.spring.heroku.biblioteca.controller;

import com.spring.heroku.biblioteca.model.LibroEntity;
import com.spring.heroku.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/libro")
public class LibroController {
    private final LibroService libroService;


    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    //---------------GET-----------------//
    @GetMapping
    public ResponseEntity<List<LibroEntity>> getAll(){
        return ResponseEntity.ok(this.libroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroEntity> get(@PathVariable("id") int idLibro) {
        return new ResponseEntity<>(this.libroService.get(idLibro), HttpStatus.OK);
    }

    //---------------POST-----------------//
    @PostMapping
    public ResponseEntity<LibroEntity> add(@RequestBody LibroEntity libro){
        if (libro.getIdLibro() == null || !this.libroService.exist(libro.getIdLibro())){
            return new ResponseEntity<>(this.libroService.save(libro), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------PUT-------------------//
    @PutMapping
    public ResponseEntity<LibroEntity> update(@RequestBody LibroEntity libro){
        if (libro.getIdLibro() != null && this.libroService.exist(libro.getIdLibro())){
            return new ResponseEntity<>(this.libroService.save(libro), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------DELETE-------------------//
    @DeleteMapping("/{id}")
    public ResponseEntity<LibroEntity> delete(@PathVariable("id") int idLibro){
        if (this.libroService.exist(idLibro)) {
            this.libroService.delete(idLibro);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
