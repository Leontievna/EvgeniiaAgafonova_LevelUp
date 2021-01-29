package test;

import common.ApiBaseTest;
import common.Endpoints;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import posts.GetPostsResponse;
import posts.PostRequest;
import posts.PostResponse;

import static io.restassured.RestAssured.given;

/**
 * postPostsDataProviderTest - класс выполняет запросы post/put/delete/get к ендпоинту /posts.
 *
 * @version 1.00 26 Jan 2021
 * @author Агафонова Евгения
 */
public class PostsRestAssuredTest extends ApiBaseTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                {"FOUR", 1004, "Active", "Inactive"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void postPostsDataProviderTest(String user, int userId, String title, String body) {

        PostRequest postRequest = new PostRequest(user, userId, title, body);

        PostResponse postResponse = given()
                .body(postRequest)
                .when()
                .post(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_POSTS)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(PostResponse.class);

        Assert.assertTrue(postResponse.getData().getUserId() == userId);

        given()
                .pathParam("id", postResponse.getData().getId())
                .queryParam("title", "Disable")
                .when()
                .put(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_POSTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertEquals(postResponse.getData().getTitle(), title);

        given()
                .pathParam("id", postResponse.getData().getId())
                .when()
                .delete(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_POSTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertEquals(postResponse.getCode(), 201);
    }

    @Test
    public void getTestsPostEntity() {

        GetPostsResponse getPostsResponse = given()
                .when()
                .get(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_POSTS)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(GetPostsResponse.class);

        Assert.assertTrue(!getPostsResponse.getMeta().getPagination().getPages().isEmpty());

        given()
                .pathParam("id", getPostsResponse.getData().get(0).getId())
                .when()
                .get(Endpoints.BASE_URL + Endpoints.MAIN_URL + Endpoints.ENTITY_URL_POSTS_PARAM)
                .then()
                .statusCode(200);

        Assert.assertTrue(!getPostsResponse.getMeta().getPagination().getPages().isEmpty());
    }
}
