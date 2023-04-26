package POJO;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Tasks {

    /**
     * Task 1
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     * expect status 200
     * Convert Into POJO
     */

    @Test
    public void task1() {

        ToDo toDo = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/2")

                .then()
                .log().body()
                .statusCode(200)
                .extract().as(ToDo.class);


        System.out.println("Todo = " + toDo);


    }

    /**
     * Task 2
     * create a request to https://httpstat.us/203
     * expect status 203
     * expect content type TEXT
     */

    @Test
    public void task2() {
        given()
                .when()
                .get("https://httpstat.us/203")
                .then()
                .log().body()
                .statusCode(203)
                .contentType(ContentType.TEXT);


    }

    /**
     * Task 3
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     * expect status 200
     * expect content type JSON
     * expect title in response body to be "quis ut nam facilis et officia qui"
     */


    @Test
    public void test3() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/2")
                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", equalTo("quis ut nam facilis et officia qui"));

    }

    /**
     * Task 4
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     * expect status 200
     * expect content type JSON
     * expect response completed status to be false
     */


    @Test
    public void task4() {

        given()

                .when()
                .get("https://jsonplaceholder.typicode.com/todos/2")
                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("completed", equalTo(false));

    }


}
















