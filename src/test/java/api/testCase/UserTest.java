package api.testCase;

import api.endPoints.UserEndPoint;
import api.payLoad.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    User userPayload;

    @BeforeClass
    public void setUp() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1)

    public void testUser() {
        Response response = UserEndPoint.createUser(userPayload);
        response.then().log().all();
        System.out.println(response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)

    public void testGetUser() {
        Response response = UserEndPoint.getUserName(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)

    public void updateUser()
    {
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        Response response = UserEndPoint.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        //response after updating

        Response responseAfterUpdate = UserEndPoint.createUser(userPayload);
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
        response.then().log().all();
    }

    @Test(priority = 4)

    public void deleteUser() {
        Response response = UserEndPoint.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
