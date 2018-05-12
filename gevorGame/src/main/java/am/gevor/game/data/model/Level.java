package am.gevor.game.data.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by karlen on 5/29/16.
 */
public class Level {

    @Id
    private String _id;

    private String id;

    private String categoryId;

    private int levelNumber;

    private int rowCount;

    private int columnCount;

    private int winMinStep;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getWinMinStep() {
        return winMinStep;
    }

    public void setWinMinStep(int winMinStep) {
        this.winMinStep = winMinStep;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
