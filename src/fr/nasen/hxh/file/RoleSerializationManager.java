package fr.nasen.hxh.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RoleSerializationManager {

    private Gson gson;

    public RoleSerializationManager(){
        this.gson = createGsonInstance();
    }

    private Gson createGsonInstance(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    public String serialize(RoleProfile profile){

        return this.gson.toJson(profile);
    }
    public RoleProfile deserialize(String json){
        return this.gson.fromJson(json, RoleProfile.class);
    }
}





