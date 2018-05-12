package am.ak.mybatis.data.client;

import am.ak.mybatis.data.model.Category;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public interface ICategoryClient {

    void add(Category category);

    List<Category> get();

    void delete(long categoryId);

    Category getById(long categoryId);

    List<Category> getByParentId(Long parentId);
}
