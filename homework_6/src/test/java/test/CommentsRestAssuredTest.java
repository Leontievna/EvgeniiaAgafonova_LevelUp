package test;

import comments.CommentsRequest;
import comments.CommentsResponse;
import common.ApiBaseTest;
import common.Endpoints;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import users.GetUsersResponse;

import static io.restassured.RestAssured.given;

/**
 * postCommentsDataProviderTest - класс выполняет запросы post/put/delete/get к ендпоинту /comments.
 *
 * @version 1.00 26 Jan 2021
 * @author Агафонова Евгения
 */
public class CommentsRestAssuredTest extends ApiBaseTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                { 21, 410, "Lorem", "Loremipsum@mail.ru", "Inactive person"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void postCommentsDataProviderTest(long post, long postId, String name, String email, String body) {

        CommentsRequest commentsRequest = new CommentsRequest(post, postId, name, email, body);

        CommentsResponse commentsResponse = given()
                .body(commentsRequest)
                .when()
                .post(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_COMMENTS)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(CommentsResponse.class);

        Assert.assertEquals(commentsResponse.getData().getName(), name);

        given()
                .pathParam("id", commentsResponse.getData().getId())
                .queryParam("name", "Ivan")
                .when()
                .put(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_COMMENTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertEquals(commentsResponse.getData().getName(), name);

        given()
                .pathParam("id", commentsResponse.getData().getId())
                .when()
                .delete(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_COMMENTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertEquals(commentsResponse.getCode(), 201);
    }

    @Test
    public void getTestsCommentsEntity() {

        GetUsersResponse getUsersResponse = given()
                .when()
                .get(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_COMMENTS)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(GetUsersResponse.class);

        Assert.assertTrue(!getUsersResponse.getMeta().getPagination().getPages().isEmpty());

        given()
                .pathParam("id", getUsersResponse.getData().get(0).getId())
                .when()
                .get(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_COMMENTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertTrue(!getUsersResponse.getMeta().getPagination().getPages().isEmpty());
    }
}
