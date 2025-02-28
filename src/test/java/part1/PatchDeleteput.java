package part1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PatchDeleteput {
    @Test
    public void TestPut()
    {
        JSONObject request=new JSONObject();
        request.put("name","SWAAA");
        request.put("position","SDET-2");
        baseURI="https://reqres.in/";
        given()
                .body(request.toJSONString())
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void TestPatch(){
        JSONObject request=new JSONObject();
        request.put("name","Shu");
        request.put("position","Manual QA");
        baseURI="https://reqres.in/";
        given()
                .body(request.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void TestDelete()
    {
        baseURI="https://reqres.in";
                given()
                        .when()
                        .delete("/api/users/2")
                        .then()
                        .statusCode(204)
                        .log().all();

    }



}
