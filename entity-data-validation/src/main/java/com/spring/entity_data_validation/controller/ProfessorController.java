package com.spring.entity_data_validation.controller;

import com.spring.entity_data_validation.entity.Professor;
import com.spring.entity_data_validation.validationGroup.CreateGroup;
import com.spring.entity_data_validation.validationGroup.UpdateGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @PostMapping("/create")
    public ResponseEntity<String> createProfessor(@RequestBody @Validated(CreateGroup.class) Professor professor){
        return ResponseEntity.ok("Professor created successfully");
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateAuthor(@RequestBody @Validated(UpdateGroup.class) Professor professor) {
        return ResponseEntity.ok("Professor updated successfully");
    }
}
