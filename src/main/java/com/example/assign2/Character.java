package com.example.assign2;


import com.google.gson.annotations.Expose;
/*
* Class to map the single character details
* */
public class Character {
    @Expose
    private String name, status, species,gender,image,url;
    @Expose
    private int id;
    @Expose
    private CharacterLocation location;

    public Character(String name, String status, String species, String gender, String image, String url, int id) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.image = image;
        this.url = url;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharacterLocation getLocation() {
        return location;
    }

    public void setLocation(CharacterLocation location) {
        this.location = location;
    }
}


