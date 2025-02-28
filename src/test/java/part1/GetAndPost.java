package part1;

import groovy.json.JsonOutput;
import jdk.jfr.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetAndPost {
    @Test
    public  void  TestGet(){
        baseURI="https://reqres.in/";
        given().
                get("api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name",equalTo("George"));



    }
    @Test
    public void TestPost(){
        JSONObject request=new JSONObject();
        request.put("name","Swa");
        request.put("position","SDET");
        baseURI="https://reqres.in/";
        given().
                header("ContentType","Application/json")
                .body(request.toJSONString())
                .when()
                    .post("/api/users")
                .then()
                    .statusCode(201)
                .log().all();

    }
}
