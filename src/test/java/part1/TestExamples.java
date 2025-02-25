package part1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestExamples {
    @Test
    public void firstTest(){
        Response response=RestAssured.get("https://automationexercise.com/api/productsList");
        System.out.println( response.getStatusCode());
        System.out.println(response.getTime());

    }
}
