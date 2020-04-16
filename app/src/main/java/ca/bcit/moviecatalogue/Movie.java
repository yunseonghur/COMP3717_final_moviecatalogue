package ca.bcit.moviecatalogue;

public class Movie {

    private String title;
    private String description;
    private String link;

    public Movie(String title, String desc, String link) {
        this.title = title;
        this.description = desc;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link=" + link +
                '}';
    }
}