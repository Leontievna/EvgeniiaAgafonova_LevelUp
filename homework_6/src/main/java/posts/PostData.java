package posts;

import com.google.gson.annotations.SerializedName;

public class PostData {

    private long id;
    @SerializedName("user_id")
    private long userId;
    private String title;
    private String body;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String apdatedAt;

    public PostData(){
    }

    public PostData(long id, long userId, String title, String body, String createdAt, String apdatedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.apdatedAt = apdatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getApdatedAt() {
        return apdatedAt;
    }

    public void setApdatedAt(String apdatedAt) {
        this.apdatedAt = apdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostData postData = (PostData) o;

        if (id != postData.id) return false;
        if (userId != postData.userId) return false;
        if (title != null ? !title.equals(postData.title) : postData.title != null) return false;
        if (body != null ? !body.equals(postData.body) : postData.body != null) return false;
        if (createdAt != null ? !createdAt.equals(postData.createdAt) : postData.createdAt != null) return false;
        return apdatedAt != null ? apdatedAt.equals(postData.apdatedAt) : postData.apdatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (apdatedAt != null ? apdatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "posts.PostData{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", apdatedAt='" + apdatedAt + '\'' +
                '}';
    }
}
