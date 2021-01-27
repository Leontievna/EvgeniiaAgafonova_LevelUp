package common;

public class PaginationData {

    private int total;
    private String pages;
    private int page;
    private int limit;

    public PaginationData(){
    }

    public PaginationData(int total, String pages, int page, int limit) {
        this.total = total;
        this.pages = pages;
        this.page = page;
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaginationData that = (PaginationData) o;

        if (total != that.total) return false;
        if (page != that.page) return false;
        if (limit != that.limit) return false;
        return pages != null ? pages.equals(that.pages) : that.pages == null;
    }

    @Override
    public int hashCode() {
        int result = total;
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + page;
        result = 31 * result + limit;
        return result;
    }

    @Override
    public String toString() {
        return "common.PaginationData{" +
                "total=" + total +
                ", pages='" + pages + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
