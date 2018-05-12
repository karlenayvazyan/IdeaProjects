package am.ak.mybatis.data.dao;

import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.model.Category;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public interface ICategoryDao {

    void add(Category category) throws DatabaseException;

    List<Category> get() throws DatabaseException;

    void delete(long categoryId) throws DatabaseException;

    Category getById(long categoryId) throws DatabaseException;

    List<Category> getByParentId(Long parentId) throws DatabaseException;
}
