package org.example.models;

public class TripList {
    private int id;

    private String tripList;
    private String username;
    private String description;

    private boolean isPub;


    public TripList(String username, String tripList, String description, int id, boolean isPub) {
        this.username = username;
        this.description = description;
        this.id = id;
        this.isPub = isPub;
        this.tripList = tripList;
    }

    public String getTripList() {
        return tripList;
    }

    public void setTripList(String tripList) {
        this.tripList = tripList;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean getIsPub() {
        return isPub;
    }

    public void setIsPub(boolean isPub) {
        this.isPub = isPub;
    }
}