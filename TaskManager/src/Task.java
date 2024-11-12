import java.util.Date;

public class Task {
    private String title;
    private Date date;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Task(String title, Date date, String text) {
        this.title = title;
        this.date = date;
        this.text = text;
    }

    // getters and setters
}
