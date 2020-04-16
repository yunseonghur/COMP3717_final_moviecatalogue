package ca.bcit.moviecatalogue;

public class Movie {

    int id;
    public String msg;
    public boolean complete;
    //    public Date date;
    public String date;

    public Movie(int id, String msg, boolean complete, String date) {
        this.id = id;
        this.msg = msg;
        this.complete = complete;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", msg='" + msg + '\'' +
                ", complete=" + complete +
                ", date=" + date +
                '}';
    }
}
