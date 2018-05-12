package am.mongodb.test.data.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by karlen on 19.05.16.
 */
public class Article {

    @Id
    private String _id;

    private String id;

    private String title;

    private String comment;

    private Date creationDate;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
