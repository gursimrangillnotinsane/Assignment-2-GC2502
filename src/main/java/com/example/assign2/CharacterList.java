package com.example.assign2;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
/*
* Main Class which is used to map the data when all the characters are requested
* */
public class CharacterList {

    @Expose
    private ArrayList<Character> results;
    @Expose

    private CharacterAllInfo info;

    public ArrayList<Character> getResults() {
        return results;
    }

    public void setResults(ArrayList<Character> results) {
        this.results = results;
    }

    public CharacterAllInfo getInfo() {
        return info;
    }

    public void setInfo(CharacterAllInfo info) {
        this.info = info;
    }
}


