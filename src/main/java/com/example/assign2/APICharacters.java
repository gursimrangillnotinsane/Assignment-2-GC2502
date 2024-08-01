package com.example.assign2;
import com.google.gson.Gson;

public class APICharacters extends APIUtility{

    public CharacterList getAllCHaracters(String uri){
        Gson gson = new Gson();
        String response = sendRequest(uri);
        return gson.fromJson(response, CharacterList.class);

    }

    public Character getOneCharacter(String id){
        String uri="https://rickandmortyapi.com/api/character/"+id;
        System.out.println(uri);
        Gson gson=new Gson();
        return gson.fromJson(sendRequest(uri),Character.class);
    }

}