package com.example.assign2;

import java.util.ArrayList;

public class Character {
    public String name, status, species,gender,image,url;
    public int id;

    public CharacterLocation location;
    public Character(String name, String status, String species, String gender, String image, String url, int id) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.image = image;
        this.url = url;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                '}';
    }
}


