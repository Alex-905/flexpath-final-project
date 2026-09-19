package org.example.controllers;

import org.example.models.TripList;
import org.example.services.TripListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/triplists")
public class TripListController {

    @Autowired
    private TripListService tripListService;

    @GetMapping
    public List<TripList> getAll() {
        return tripListService.getTripLists();
    }

    @GetMapping(path = "/{id}")
    public TripList get(@PathVariable int id) {
        return tripListService.getTripListById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TripList create(@RequestBody TripList tripList) {
        return tripListService.createTripList(tripList);
    }

    @PutMapping(path = "/{id}")
    public TripList update(@PathVariable int id, @RequestBody TripList tripList) {
        tripList.setId(id);
        return tripListService.updateTripList(tripList);
    }

    @DeleteMapping(path = "/{id}")
    public int delete(@PathVariable int id) {
        return tripListService.deleteTripList(id);
    }

    @PostMapping(path = "/{tripListId}/resorts/{resortId}")
    public void addResort(@PathVariable int tripListId, @PathVariable int resortId) {
        tripListService.addResortToTripList(tripListId, resortId);
    }

    @DeleteMapping(path = "/{tripListId}/resorts/{resortId}")
    public void removeResort(@PathVariable int tripListId, @PathVariable int resortId) {
        tripListService.removeResortFromTripList(tripListId, resortId);
    }

    @GetMapping(path = "/{tripListId}/resorts")
    public List<Integer> getResortIds(@PathVariable int tripListId) {
        return tripListService.getResortIdsInTripList(tripListId);
    }

}
