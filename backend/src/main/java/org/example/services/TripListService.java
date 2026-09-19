package org.example.services;

import org.example.daos.TripListDao;
import org.example.models.Resort;
import org.example.models.TripList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripListService {

    private final TripListDao tripListDao;

    public TripListService(TripListDao tripListDao) {
        this.tripListDao = tripListDao;
    }

    public List<TripList> getTripLists() {
        return tripListDao.getTripLists();
    }

    public TripList getTripListById(int id) {
        return tripListDao.getTripListById(id);
    }

    public TripList createTripList(TripList tripList) {
        return tripListDao.createTripList(tripList);
    }

    public TripList updateTripList(TripList tripList) {
        return tripListDao.updateTripList(tripList);
    }

    public int deleteTripList(int id) {
        return tripListDao.deleteTripList(id);
    }

    public void addResortToTripList(int tripListId, int resortId) {
        tripListDao.addResortToTripList(tripListId, resortId);
    }

    public void removeResortFromTripList(int tripListId, int resortId) {
        tripListDao.removeResortFromTripList(tripListId, resortId);
    }

    public List<Integer> getResortIdsInTripList(int tripListId) {
        return tripListDao.getResortIdsInTripList(tripListId);
    }

}