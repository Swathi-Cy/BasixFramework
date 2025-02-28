package part1;

import io.restassured.http.ContentType;
import org.checkerframework.checker.units.qual.K;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class TestsOnLocalAPI {
    //@Test
    public void testGet()
    {
        baseURI="http://localhost:3000/";
        given().get("/users").then().statusCode(200).log().all();
    }
   // @Test
    public void testPost(){
        JSONObject request = new JSONObject();
        request.put("name","Manual");
        baseURI="http://localhost:3000/";
        given().
                    contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(request.toJSONString())
                .when()
                    .post("/subjects")
                .then()
                .statusCode(201)
                .log().all();


    }

    //@Test
    public void testPut(){
        JSONObject req=new JSONObject();
        req.put("name","CS");
        baseURI="http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put("subjects/2")
                .then()
                .statusCode(200);



    }
    //@Test
    public void testPatch(){
        JSONObject req=new JSONObject();
        req.put("name","Lol");
        baseURI="http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .patch("subjects/2")
                .then()
                .statusCode(200);



    }
    @Test
    public void testDelete(){
        baseURI="http://localhost:3000/";
        when().delete("subjects/2").then().statusCode(200).log().all();


    }




}
