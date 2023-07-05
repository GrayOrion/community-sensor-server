package com.greenmonster.communitysensor.controller;

import com.greenmonster.communitysensor.model.Content;
import com.greenmonster.communitysensor.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin()
public class ContentController {

    private final ContentCollectionRepository repository;

    @Autowired // not needed when only one constructor
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
        // repository = new ContentCollectionRepository(); - wrong, inversion of control tells us that the application context has one already
    }

    // make a request and find all the pieces of content in the system
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    // Create Read Update Delete - filter | paging and sorting

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!repository.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.delete(id);
    }

}
