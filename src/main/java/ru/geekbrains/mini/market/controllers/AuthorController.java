package ru.geekbrains.mini.market.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.mini.market.dto.AuthorDto;
import ru.geekbrains.mini.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.mini.market.entities.Author;
import ru.geekbrains.mini.market.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@Api("Set of endpoints for authors")
public class AuthorController {
    private AuthorService authorService;

    @GetMapping
    @ApiOperation("Returns all authors")
    public List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //GET http://localhost:8181/market/api/v1/authors/1
    @GetMapping("/{id}")
    @ApiOperation("Returns a specific author by their identifier. 404 if does not exist.")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        Author author = authorService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find author with id: " + id));
        return new AuthorDto(author);
    }


}
