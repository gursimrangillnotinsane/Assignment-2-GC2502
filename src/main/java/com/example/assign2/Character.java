package com.example.assign2;

import java.util.ArrayList;

public class Character {
    public String name, status, species,gender,image,url;
    public int id;

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


