package am.ak.mybatis.action.user;

import am.ak.mybatis.action.BaseAction;
import am.ak.mybatis.data.exception.InternalErrorException;
import am.ak.mybatis.data.manager.ICategoryManager;
import am.ak.mybatis.data.model.Category;
import am.ak.mybatis.data.model.Language;
import am.ak.mybatis.util.Validator;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public class AddCategoryAction extends BaseAction implements ModelDriven<Category> {

    @Autowired
    private ICategoryManager categoryManager;

    private Long categoryId;

    private Category category = new Category();

    private List<File> images;
    private String[] imagesFileName;
    private String[] imagesContentType;

    @SkipValidation
    public String view() {
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        try {
            categoryManager.add(category);
            return SUCCESS;
        } catch (/*InternalError*/Exception e) {
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

    public Category getModel() {
        return category;
    }

    public List<File> getImages() {
        return images;
    }

    public void setImages(List<File> images) {
        this.images = images;
    }

    public String[] getImagesFileName() {
        return imagesFileName;
    }

    public void setImagesFileName(String[] imagesFileName) {
        this.imagesFileName = imagesFileName;
    }

    public String[] getImagesContentType() {
        return imagesContentType;
    }

    public void setImagesContentType(String[] imagesContentType) {
        this.imagesContentType = imagesContentType;
    }
}
