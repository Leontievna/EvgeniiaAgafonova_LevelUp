package common;

public class UsersTokenRequest {

    private String token = "4f229e772774e1a9e5a6efedcf9480f7bed2223c9e9b3f0bc3f90cfd3626a784";

    public UsersTokenRequest() {
    }

    public UsersTokenRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersTokenRequest that = (UsersTokenRequest) o;

        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        return token != null ? token.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "common.UsersTokenRequest{" +
                "token='" + token + '\'' +
                '}';
    }
}
