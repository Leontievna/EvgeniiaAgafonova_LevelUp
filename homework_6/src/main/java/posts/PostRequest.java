package posts;

import com.google.gson.annotations.SerializedName;

public class PostRequest {

    private String user;
    @SerializedName("user_id")
    private int userId;
    private String title;
    private String body;

    public PostRequest(){
    }

    public PostRequest(String user, int userId, String title, String body) {
        this.user = user;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostRequest that = (PostRequest) o;

        if (userId != that.userId) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + userId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "posts.PostRequest{" +
                "user='" + user + '\'' +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
//        "code": 422,
//            "meta": null,
//            "data": [
//        {
//            "field": "user",
//                "message": "must exist"
//        },
//        {
//            "field": "user_id",
//                "message": "can't be blank"
//        },
//        {
//            "field": "title",
//                "message": "can't be blank"
//        },
//        {
//            "field": "body",
//                "message": "can't be blank"
//        }
//  ]
//    }

