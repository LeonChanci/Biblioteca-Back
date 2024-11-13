package com.spring.heroku.biblioteca.controller;

import com.spring.heroku.biblioteca.model.LibroEntity;
import com.spring.heroku.biblioteca.service.LibraryXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/books")
    public ResponseEntity<List<LibroEntity>> getBooksFromXML(){
        return ResponseEntity.ok(this.libraryXMLService.findBooksFromXML());
    }

    @GetMapping("/totalValue")
    public ResponseEntity<Integer> getTotalBooksWithMoreOneCategory(){
        return ResponseEntity.ok(this.libraryXMLService.findTotalBooksWithMoreOneCategory());
    }

    @GetMapping("/percentageValue")
    public ResponseEntity<Double> getPercentageBooksAfterYear2000(){
        return ResponseEntity.ok(this.libraryXMLService.findPercentageBooksAfterYear2000());
    }

    @GetMapping("/filterByAttribute/{anoPublicacion}")
    public ResponseEntity<List<LibroEntity> > getBooksByAttribute(@PathVariable("anoPublicacion") int anoPublicacion){
        return ResponseEntity.ok(this.libraryXMLService.findBooksByAttribute(anoPublicacion));
    }
}
