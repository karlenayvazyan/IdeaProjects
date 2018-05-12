package am.ak.mybatis.action.user;

import am.ak.mybatis.action.BaseAction;
import am.ak.mybatis.data.manager.ICategoryManager;
import am.ak.mybatis.data.model.Category;
import am.ak.mybatis.data.model.Language;
import am.ak.mybatis.util.Validator;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by karlen on 17.04.16.
 */
public class EditCategoryAction extends BaseAction {

    @Autowired
    private ICategoryManager categoryManager;

    private Long categoryId;

    private Category category;

    @SkipValidation
    public String view() {
        try {
            if (categoryId <= 0) {
                addActionError("Category id empty");
                return INPUT;
            }
            category = categoryManager.getById(categoryId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Override
    public String execute() {
        try {
            categoryManager.edit(category);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Override
    public void validate() {
        boolean isValid = true;
        if (category != null) {
            List<Language> language = category.getLanguages();
            if (!Validator.isEmpty(language)) {
                for (Language lang : language) {
                    if (lang != null) {
                        if (Validator.isEmpty(lang.getText())) {
                            isValid = false;
                        }

                        if (lang.getLanguage() == null) {
                            isValid = false;
                        }
                    } else {
                        isValid = false;
                    }
                }
            } else {
                isValid = false;;
            }
        } else {
            isValid = false;
        }
        if (!isValid) {
            addActionError("please fill all required fields");
        }
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
