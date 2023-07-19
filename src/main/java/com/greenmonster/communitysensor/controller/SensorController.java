package com.greenmonster.communitysensor.controller;

import com.greenmonster.communitysensor.model.Sensor;
import com.greenmonster.communitysensor.repository.SensorCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

    private final SensorCollectionRepository repository;

    @Autowired // not needed when only one constructor
    public SensorController(SensorCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Sensor> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Sensor findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Sensor sensor) {
        repository.save(sensor);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Sensor sensor, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sensor not found");
        }

        repository.save(sensor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}