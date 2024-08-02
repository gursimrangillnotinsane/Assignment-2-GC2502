package com.example.assign2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
*  Class which contains the main api-functions
* */
public class APICharacters extends APIUtility{

    /**
     * To get multiple character info
     * @param url of the api
     * @return All characters as an Arraylist
     */
    public CharacterList getAllCHaracters(String url){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String response = sendRequest(url);
        return gson.fromJson(response, CharacterList.class);
    }

    /**
     * TO get one character info
     * @param id of the character
     * @return detailed information of the character
     */
    public Character getOneCharacter(String id){
        String uri="https://rickandmortyapi.com/api/character/"+id;
        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.fromJson(sendRequest(uri),Character.class);
    }

}