package am.ak.mybatis.data.model;

import java.util.Date;

/**
 * Created by karlen on 03.04.16.
 */
public class Sound {

    private Long id;

    private Category category;

    private File file;

    private Date creationDate;

    public Sound() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
