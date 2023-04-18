import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZippoTest {


    @Test
    public void test(){

        given()     //preparation (token, request body, parameters)
                .when()         //for URL and request method (get, post, put, delete)
                .then();        //response body, assertions, extract data from the response

    }

    @Test
    public void test1(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()      // prints the response body
                .log().status()
                .statusCode(200);   // checks if the status code is 200
    }

@Test
    public void contentTypeTest(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON);      //checks if the response is in JSON format

    }

    @Test
    public void checkCountryFromResponseBody(){
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .body("country",equalTo("United States"));

    }

    //PostMan                                               //Rest Assured
    //pm.response.json().'post code'                        //body("post code", ...)
    //pm.response.json.places[0].'place name'               //body("places[0].'place name', ...")
    //pm.response.json.places.'place name'                  //body("places.'place name'")


    @Test
    public void checkStateFromResponse(){
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .statusCode(200)
                .body("places[0].state",equalTo("California")); // checks if the state is California


    }

    @Test
    public void bodyHasItem(){
        given()

                .when()
                .get("http://api.zippopotam.us/tr/01000")
                .then()
                .log().body()
                .statusCode(200)
                .body("places.'place name'",hasItem("Büyükdikili Köyü"));
    }

    @Test
    public void bodyArraySizeTest(){
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .statusCode(200)
                .body("places",hasSize(1));

    }


}
