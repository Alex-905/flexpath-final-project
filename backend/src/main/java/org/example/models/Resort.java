package org.example.models;

public class Resort {
    private int id;
    private int base;
    private int vertDrop;
    private int avgSnow;

    private String username;
    private String resortName;
    private String location;
    private String diffLevel;
    private String description;

    private boolean isPub;


    public Resort(String username, String resortName, String location, String diffLevel, String description, int id, int base, int vertDrop, int avgSnow, boolean isPub) {
        this.username = username;
        this.resortName = resortName;
        this.location = location;
        this.diffLevel = diffLevel;
        this.description = description;
        this.id = id;
        this.base = base;
        this.vertDrop = vertDrop;
        this.avgSnow = avgSnow;
        this.isPub = isPub;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResortName() {
        return resortName;
    }

    public void setResortName(String resortName) {
        this.resortName = resortName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDiffLevel() {
        return diffLevel;
    }

    public void setDiffLevel(String diffLevel) {
        this.diffLevel = diffLevel;
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

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getVertDrop() {
        return vertDrop;
    }

    public void setVertDrop(int vertDrop) {
        this.vertDrop = vertDrop;
    }

    public int getAvgSnow() {
        return avgSnow;
    }

    public void setAvgSnow(int avgSnow) {
        this.avgSnow = avgSnow;
    }

    public boolean getIsPub() {
        return isPub;
    }

    public void setIsPub(boolean isPub) {
        this.isPub = isPub;
    }
}

