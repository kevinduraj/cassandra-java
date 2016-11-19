package kduraj;

public class Movie {

    private String title;
    private Integer year;
    private String description;
    private String rating;

    /*------------------------------------------------------------------------------------------*/
    public Movie(String title, int year, String description, String rating) {

        this.setTitle(title);
        this.setYear(year);
        this.setDescription(description);
        this.setRating(rating);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    /*------------------------------------------------------------------------------------------*/

}
