package am.ak.mybatis.action.user;

import am.ak.mybatis.action.BaseAction;
import am.ak.mybatis.data.manager.ICategoryManager;
import am.ak.mybatis.data.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by karlen on 16.04.16.
 */
public class HomeAction extends BaseAction {

    @Autowired
    private ICategoryManager categoryManager;

    private List<Category> categories;

    private Long categoryId;

    @Override
    public String execute() throws Exception {
        try {
            categories = categoryManager.get(categoryId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
