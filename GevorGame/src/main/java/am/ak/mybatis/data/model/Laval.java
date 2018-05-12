package am.ak.mybatis.data.model;

import java.util.Date;

/**
 * Created by karlen on 03.04.16.
 */
public class Laval {

    private Long id;

    private Category category;

    private Integer lavalNumber;

    private Integer rowCount;

    private Integer columnCount;

    private Integer winMinStep;

    private Date creationDate;

    public Laval() {}

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

    public Integer getLavalNumber() {
        return lavalNumber;
    }

    public void setLavalNumber(Integer lavalNumber) {
        this.lavalNumber = lavalNumber;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public Integer getWinMinStep() {
        return winMinStep;
    }

    public void setWinMinStep(Integer winMinStep) {
        this.winMinStep = winMinStep;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
