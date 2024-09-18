package com.spring.entity_data_validation.service;

import com.spring.entity_data_validation.entity.Author;
import com.spring.entity_data_validation.exception.AuthorNotFoundException;
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


    public Author getAuthor(int id) throws AuthorNotFoundException {
        Author author = authorRepo.findByAuthorId(id);
        if(author != null){
            return author;
        }else{
            throw new AuthorNotFoundException("Author not found with id: "+id);
        }

    }


}
