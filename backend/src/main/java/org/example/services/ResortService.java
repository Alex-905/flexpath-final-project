package org.example.services;

import org.example.daos.ResortDao;
import org.example.models.Resort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResortService {

    private final ResortDao resortDao;

    public ResortService(ResortDao resortDao) {
        this.resortDao = resortDao;
    }

    public List<Resort> getResorts() {
        return resortDao.getResorts();
    }

    public Resort getResortById(int id) {
        return resortDao.getResortById(id);
    }

    public Resort createResort(Resort resort) {
        return resortDao.createResort(resort);
    }

    public Resort updateResort(Resort resort) {
        return resortDao.updateResort(resort);
    }

    public int deleteResort(int id) {
        return resortDao.deleteResort(id);
    }
}