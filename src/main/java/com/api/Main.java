package com.api;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;
public class Main {

    public static void main(String[] args) {

        String apiKey = "5a5e27db7b5a73fdc08b4ea30026650d";
        String token = "098a7f769ca1f4eae6294b655e9a25e20be0a05d82a2c6fb44ee9e6e2bdd2c52";

        RestAssured.baseURI = "https://api.trello.com/1/";



    }
}
