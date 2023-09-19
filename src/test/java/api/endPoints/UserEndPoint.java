package api.endPoints;

import api.payLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoint {

    public static Response createUser(User payload)
    {
       Response response;
        response = given().contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                 .body(payload)
                 .when().post(RoutesBaseURL.post_URL);

        return response;
    }

    public static Response getUserName(String userName)
    {
        Response response;
        response = given().pathParam("username",userName)
                .when().get(RoutesBaseURL.get_URL);
        return response;
    }

    public static Response updateUser(String userName,User payload)
    {
        Response response;
        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)
                .when().post(RoutesBaseURL.update_URL);

        return response;
    }

    public static Response deleteUser(String userName)
    {
        Response response;
        response = given().pathParam("username",userName)
                .when().get(RoutesBaseURL.delete_URL);
        return response;
    }






}
