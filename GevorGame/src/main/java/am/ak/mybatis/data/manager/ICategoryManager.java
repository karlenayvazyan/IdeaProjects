package am.ak.mybatis.data.manager;

import am.ak.mybatis.data.exception.EntityNotFoundException;
import am.ak.mybatis.data.exception.InternalErrorException;
import am.ak.mybatis.data.model.Category;

import java.util.List;

/**
 * Created by karlen on 03.04.16.
 */
public interface ICategoryManager {

    void add(Category category) throws InternalErrorException;

    List<Category> get(Long parentId) throws InternalErrorException;

    Category getById(long categoryId) throws InternalErrorException;

    void edit(Category category) throws InternalErrorException;

    void delete(long categoryId) throws InternalErrorException, EntityNotFoundException;
}
