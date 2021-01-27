package comments;

import common.MetaData;
import java.util.List;

public class GetCommentsResponse {

    private int code;
    private MetaData meta;
    private List<CommentsData> data;

    public GetCommentsResponse (){
    }

    public GetCommentsResponse(int code, MetaData meta, List<CommentsData> data) {
        this.code = code;
        this.meta = meta;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public List<CommentsData> getData() {
        return data;
    }

    public void setData(List<CommentsData> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetCommentsResponse that = (GetCommentsResponse) o;

        if (code != that.code) return false;
        if (meta != null ? !meta.equals(that.meta) : that.meta != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (meta != null ? meta.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "comments.GetCommentsResponse{" +
                "code=" + code +
                ", meta=" + meta +
                ", data=" + data +
                '}';
    }
}

