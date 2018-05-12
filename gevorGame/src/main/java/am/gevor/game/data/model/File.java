package am.gevor.game.data.model;

/**
 * Created by karlen on 5/29/16.
 */
public class File {

    private Long size;

    private String name;

    private String contentType;

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
