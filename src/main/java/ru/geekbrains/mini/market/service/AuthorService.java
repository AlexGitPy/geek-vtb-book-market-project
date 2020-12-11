package ru.geekbrains.mini.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.mini.market.entities.Author;
import ru.geekbrains.mini.market.repositories.AuthorRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getOneById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
