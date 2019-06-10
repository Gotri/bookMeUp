package bookmeup.book;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "state")
    private String state;

    @Column(name = "shelves")
    private String shelves;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_reference")
    private String coverReference;

    @Column(name = "genres")
    private String genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "Book{" +
                "id=" + id +
                ", pages=" + pages +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", userId=" + userId +
                ", state='" + state + '\'' +
                ", shelves='" + shelves + '\'' +
                ", description='" + description + '\'' +
                ", coverReference='" + coverReference + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
