package com.spring.heroku.biblioteca.controller;

import com.spring.heroku.biblioteca.model.ClienteEntity;
import com.spring.heroku.biblioteca.model.LibroEntity;
import com.spring.heroku.biblioteca.service.ClienteService;
import com.spring.heroku.biblioteca.service.LibraryXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/libraryXml")
public class LibraryXMLController {
    private final LibraryXMLService libraryXMLService;

    @Autowired
    public LibraryXMLController(LibraryXMLService libraryXMLService) {
        this.libraryXMLService = libraryXMLService;
    }

    @GetMapping
    public ResponseEntity<List<LibroEntity>> getBooksFromXML(){
        return ResponseEntity.ok(this.libraryXMLService.findBooksFromXML());
    }
}
