package org.example.controllers;

import org.example.models.Resort;
import org.example.services.ResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resorts")
public class ResortController {

    @Autowired
    private ResortService resortService;

    @GetMapping
    public List<Resort> getAll() {
        return resortService.getResorts();
    }

    @GetMapping(path = "/{id}")
    public Resort get(@PathVariable int id) {
        return resortService.getResortById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resort create(@RequestBody Resort resort) {
        return resortService.createResort(resort);
    }

    @PutMapping(path = "/{id}")
    public Resort update(@PathVariable int id, @RequestBody Resort resort) {
        resort.setId(id);
        return resortService.updateResort(resort);
    }


    @GetMapping(path = "/search")
    public List<Resort> search(@RequestParam String location, @RequestParam String diffLevel) {
        return resortService.searchResorts(location, diffLevel);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public int delete(@PathVariable int id) {
        return resortService.deleteResort(id);
    }
}