import com.api.Main;
import com.api.Post;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class BaseTest{
    String apiKey="5a5e27db7b5a73fdc08b4ea300d18c26650dd";
    String token="098a7f769ca1f4eae6294b655e9a25e20da13be0a05d82a2c6fb44ee9e6e2bdd2c52";

    @Before
    public void Setup()
    {
        RestAssured.baseURI="https://api.trello.com/1/";

    }
    /*public static Integer  getUserIdFromRequest(){
        Response response =
                given()
                        .log().all()
                        .when().get("/boards").prettyPeek()
                        .then().extract().response();

        Random random = new Random();
        int rastgeleSayi = random.nextInt(Integer.parseInt(response.jsonPath().getString("id.size")));
        int randomId = response.jsonPath().get("["+rastgeleSayi+"].id");
        System.out.println(randomId);
        return randomId;
    }*/
    public void postRequest()
    {

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .pathParam("apiKey",apiKey)
                        .pathParam("token",token)
                        .post("boards/?name=yeniBoard4&key={apiKey}&token={token}")
                        .then()
                        .statusCode(200).extract().response();
        String id=response.jsonPath().getString("id");
        System.out.println(id);
    }
    public void getRequest()
    {
        Response response=
                given()
                .contentType(ContentType.JSON)
                        .pathParam("apiKey",apiKey)
                        .pathParam("token",token)
                .get("boards/5eb75da7f9fbdd7df4c896a4?key={apiKey}&token={token}")
                .then()
                .statusCode(200)
                        .log().all()
                .extract().response();

    }

    public void deleteRequest()
    {
        Response response=
                given()
                .contentType(ContentType.JSON)
                        .pathParam("apiKey",apiKey)
                        .pathParam("token",token)
                .delete("boards/5eb75be10b37b7683045c3a2?key={apiKey}&token={token}")
                .then()
                .statusCode(200)
                .extract().response();
    }

    public void putRequest()
    {
        Response response=
                given()
                .contentType(ContentType.JSON)
                .pathParam("apiKey",apiKey)
                .pathParam("token",token)
                .put("boards/5eb75da7f9fbdd7df4c896a4?name=nevinkarasu&key={apiKey}&token={token}")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test
    public void Test1()
    {
        postRequest();
    }
    @Test
    public void Test2()
    {
        getRequest();
    }
    @Test
    public void Test3()
    {
        deleteRequest();
    }
    @Test
    public void Test4()
    {
        putRequest();
    }

}
