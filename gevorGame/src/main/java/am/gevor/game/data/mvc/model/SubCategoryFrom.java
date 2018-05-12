package am.gevor.game.data.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by karlen on 5/30/16.
 */
public class SubCategoryFrom {

    @Valid
    @NotNull
    private List<LanguageForm> languages;

    private MultipartFile fileSize1;

    private MultipartFile fileSize2;

    private MultipartFile fileSize3;

    private MultipartFile fileSize4;

    private MultipartFile fileSize5;

    @NotNull
    @NotEmpty
    private String categoryId;

    public List<LanguageForm> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageForm> languages) {
        this.languages = languages;
    }

    public MultipartFile getFileSize1() {
        return fileSize1;
    }

    public void setFileSize1(MultipartFile fileSize1) {
        this.fileSize1 = fileSize1;
    }

    public MultipartFile getFileSize2() {
        return fileSize2;
    }

    public void setFileSize2(MultipartFile fileSize2) {
        this.fileSize2 = fileSize2;
    }

    public MultipartFile getFileSize3() {
        return fileSize3;
    }

    public void setFileSize3(MultipartFile fileSize3) {
        this.fileSize3 = fileSize3;
    }

    public MultipartFile getFileSize4() {
        return fileSize4;
    }

    public void setFileSize4(MultipartFile fileSize4) {
        this.fileSize4 = fileSize4;
    }

    public MultipartFile getFileSize5() {
        return fileSize5;
    }

    public void setFileSize5(MultipartFile fileSize5) {
        this.fileSize5 = fileSize5;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
