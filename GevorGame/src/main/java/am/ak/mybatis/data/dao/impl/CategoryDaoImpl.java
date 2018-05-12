package am.ak.mybatis.data.dao.impl;

import am.ak.mybatis.data.client.ICategoryClient;
import am.ak.mybatis.data.dao.ICategoryDao;
import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public class CategoryDaoImpl implements ICategoryDao {

    @Autowired
    private ICategoryClient categoryClient;

    public void add(Category category) throws DatabaseException {
        try {
            categoryClient.add(category);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public List<Category> get() throws DatabaseException {
        try {
            return categoryClient.get();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void delete(long categoryId) throws DatabaseException {
        try {
            categoryClient.delete(categoryId);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public Category getById(long categoryId) throws DatabaseException {
        try {
            return categoryClient.getById(categoryId);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public List<Category> getByParentId(Long parentId) throws DatabaseException {
        try {
            return categoryClient.getByParentId(parentId);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
