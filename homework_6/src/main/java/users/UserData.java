package users;

import com.google.gson.annotations.SerializedName;

public class UserData {

    private long id;
    private String name;
    private String gender;
    private String email;
    private String status;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String apdatedAt;

    public UserData(){
    }

    public UserData(long id, String name, String gender, String email, String status, String createdAt, String apdatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
        this.apdatedAt = apdatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (name != null ? !name.equals(userData.name) : userData.name != null) return false;
        if (gender != null ? !gender.equals(userData.gender) : userData.gender != null) return false;
        if (email != null ? !email.equals(userData.email) : userData.email != null) return false;
        if (status != null ? !status.equals(userData.status) : userData.status != null) return false;
        if (createdAt != null ? !createdAt.equals(userData.createdAt) : userData.createdAt != null) return false;
        return apdatedAt != null ? apdatedAt.equals(userData.apdatedAt) : userData.apdatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (apdatedAt != null ? apdatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "users.UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", apdatedAt='" + apdatedAt + '\'' +
                '}';
    }
}
