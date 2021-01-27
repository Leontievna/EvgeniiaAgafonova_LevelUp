package comments;

import com.google.gson.annotations.SerializedName;

public class CommentsData {

    private long id;
    @SerializedName("post_id")
    private long postId;
    private String name;
    private String email;
    private String body;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String apdatedAt;

    public CommentsData(){
    }

    public CommentsData(long id, long postId, String name, String email, String body, String createdAt, String apdatedAt) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
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

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        CommentsData that = (CommentsData) o;

        if (id != that.id) return false;
        if (postId != that.postId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        return apdatedAt != null ? apdatedAt.equals(that.apdatedAt) : that.apdatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (postId ^ (postId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (apdatedAt != null ? apdatedAt.hashCode() : 0);
        return result;
    }
}
