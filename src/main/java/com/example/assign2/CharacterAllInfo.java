package com.example.assign2;

import com.google.gson.annotations.Expose;

/*
* Class to map the next and previous url of the page in the info part
* */
public class CharacterAllInfo {
    @Expose
    private String next,prev;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
}
