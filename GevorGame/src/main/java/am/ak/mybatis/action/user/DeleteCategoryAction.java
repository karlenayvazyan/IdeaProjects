package am.ak.mybatis.action.user;

import am.ak.mybatis.action.BaseAction;
import am.ak.mybatis.data.manager.ICategoryManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karlen on 16.04.16.
 */
public class DeleteCategoryAction extends BaseAction {

    @Autowired
    private ICategoryManager categoryManager;

    private int categoryId;

    @Override
    public String execute() {
        try {
            categoryManager.delete(categoryId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
