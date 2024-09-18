package com.spring.entity_data_validation.controller;

import com.spring.entity_data_validation.entity.Author;
import com.spring.entity_data_validation.exception.AuthorNotFoundException;
import com.spring.entity_data_validation.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private AuthorService authorService;

    @PostMapping("/author/add")
    public ResponseEntity<String> createAuthor(@RequestBody @Valid Author author , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return ResponseEntity.badRequest().body("Validation failed");
        }
        authorService.saveAuthor(author);

        return ResponseEntity.ok("Author created successfully");
    }


    @GetMapping("/author/get")
    public ResponseEntity<Author> getAuthor(@PathVariable int id) throws AuthorNotFoundException {
        return ResponseEntity.ok(authorService.getAuthor(id));
    }




}
