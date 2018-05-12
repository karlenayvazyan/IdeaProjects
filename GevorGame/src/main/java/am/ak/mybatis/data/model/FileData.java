package am.ak.mybatis.data.model;

import java.util.List;

/**
 * Created by karlen on 27.04.16.
 */
public class FileData {

    private String languageAm;

    private String languageRu;

    private String languageEn;

    private Long categoryId;

    private List<File> files;

    public String getLanguageAm() {
        return languageAm;
    }

    public void setLanguageAm(String languageAm) {
        this.languageAm = languageAm;
    }

    public String getLanguageRu() {
        return languageRu;
    }

    public void setLanguageRu(String languageRu) {
        this.languageRu = languageRu;
    }

    public String getLanguageEn() {
        return languageEn;
    }

    public void setLanguageEn(String languageEn) {
        this.languageEn = languageEn;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
