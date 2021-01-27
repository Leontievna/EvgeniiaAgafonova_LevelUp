package test;

import common.ApiBaseTest;
import common.Endpoints;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import users.GetUsersResponse;
import users.UsersRequest;
import users.UsersResponse;

import static io.restassured.RestAssured.given;

/**
 * test.UsersRestAssuredTest - класс выполняет запросы post/put/delete/get к ендпоинту /users.
 *
 * @version 1.00 26 Jan 2021
 * @author Агафонова Евгения
 */
public class UsersRestAssuredTest extends ApiBaseTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                { "koperkin@mail.ru", "Petr", "Male", "Inactive"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void postUsersDataProviderTest(String email, String name, String gender, String status) {

        UsersRequest usersRequest = new UsersRequest(email, name, gender, status);

        UsersResponse usersResponse = given()
                .body(usersRequest)
                .when()
                .post(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_USERS)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(UsersResponse.class);

        Assert.assertEquals(usersResponse.getData().getName(), name);

        given()
                .pathParam("id", usersResponse.getData().getId())
                .queryParam("name", "Piter")
                .when()
                .put(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_USERS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertEquals(usersResponse.getData().getName(), name);

        given()
                .pathParam("id", usersResponse.getData().getId())
                .when()
                .delete(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_POSTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertEquals(usersResponse.getCode(), 201);
    }

    @Test
    public void getTestsUsersEntity() {

        GetUsersResponse getUsersResponse = given()
                .when()
                .get(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_USERS)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(GetUsersResponse.class);

        Assert.assertTrue(!getUsersResponse.getMeta().getPagination().getPages().isEmpty());

        given()
                .pathParam("id", getUsersResponse.getData().get(0).getId())
                .when()
                .get(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_USERS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertTrue(!getUsersResponse.getMeta().getPagination().getPages().isEmpty());
    }
}
