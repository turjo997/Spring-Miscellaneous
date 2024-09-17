package com.spring.entity_data_validation.service;

import com.spring.entity_data_validation.entity.Author;
import com.spring.entity_data_validation.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;


    public void saveAuthor(Author author) {
        authorRepo.save(author);
    }
}
