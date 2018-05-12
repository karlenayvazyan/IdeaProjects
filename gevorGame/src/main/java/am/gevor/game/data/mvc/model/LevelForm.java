package am.gevor.game.data.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by karlen on 5/30/16.
 */
public class LevelForm {

    @NotNull
    private Integer levelNumber;

    @NotNull
    private Integer rowCount;

    @NotNull
    private Integer columnCount;

    @NotNull
    private Integer winMinStep;

    @NotNull
    @NotEmpty
    private String categoryId;

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
