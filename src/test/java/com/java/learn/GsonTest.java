package com.java.learn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import org.junit.Test;

public class GsonTest {
    @Test
    public void testGson() {
        Gson gson = new GsonBuilder().create();
        String json = "{\"ao\":1,\"bo\":{\"id\":2,\"name\":\"jj\"}}";
        User jsonObject = gson.fromJson(json, User.class);
        System.out.println(jsonObject.a);
        System.out.println(jsonObject.b.id);
        System.out.println(jsonObject.b.name);

        String result = gson.toJson(jsonObject);
        System.out.println(result);
    }
}

class User {
    @SerializedName("ao")
    int a;

    @SerializedName("bo")
    Person b;
}

class Person {
    int id;
    String name;
}
