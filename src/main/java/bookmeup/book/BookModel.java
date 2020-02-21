package bookmeup.book;

public class BookModel {

    private Integer pages;

    private Integer rating;

    private String title;

    private String author;

    private Long userId;

    private String state;

    private String shelves;

    private String description;

    private String coverReference;

    private String genres;

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShelves() {
        return shelves;
    }

    public void setShelves(String shelves) {
        this.shelves = shelves;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverReference() {
        return coverReference;
    }

    public void setCoverReference(String coverReference) {
        this.coverReference = coverReference;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "pages=" + pages +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", userId=" + userId +
                ", state='" + state + '\'' +
                ", shelves='" + shelves + '\'' +
                ", description='" + description + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
