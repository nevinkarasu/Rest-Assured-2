package com.api;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class Ornek {
    public void T() {

        Gson gson = new Gson();
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        File file = new File(classLoader.getResource("users.json").getFile());

        try {
            FileReader reader = new FileReader(file.getPath());
            Post post = gson.fromJson(reader, Post.class);
            RestAssured.baseURI = "https://api.trello.com/1/";

            String name = given()
                    .contentType(ContentType.JSON)
                    .body(post)
                    .when().post("users")
                    .then()
                    .statusCode(200)
                    .extract()
                    .jsonPath().get().toString();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}