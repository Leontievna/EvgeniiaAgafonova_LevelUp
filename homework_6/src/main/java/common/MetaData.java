package common;

public class MetaData {

    private PaginationData pagination;

    public MetaData(){
    }

    public MetaData(PaginationData pagination) {
        this.pagination = pagination;
    }

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaData metaData = (MetaData) o;

        return pagination != null ? pagination.equals(metaData.pagination) : metaData.pagination == null;
    }

    @Override
    public int hashCode() {
        return pagination != null ? pagination.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "common.MetaData{" +
                "pagination=" + pagination +
                '}';
    }
}
