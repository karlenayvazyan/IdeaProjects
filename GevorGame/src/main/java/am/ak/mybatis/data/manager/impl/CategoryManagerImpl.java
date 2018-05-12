package am.ak.mybatis.data.manager.impl;

import am.ak.mybatis.data.dao.ICategoryDao;
import am.ak.mybatis.data.dao.ILanguageDao;
import am.ak.mybatis.data.exception.DatabaseException;
import am.ak.mybatis.data.exception.EntityNotFoundException;
import am.ak.mybatis.data.exception.InternalErrorException;
import am.ak.mybatis.data.manager.ICategoryManager;
import am.ak.mybatis.data.model.Category;
import am.ak.mybatis.data.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by karlen on 03.04.16.
 *
 */
@Transactional(readOnly = true)
public class CategoryManagerImpl implements ICategoryManager {

    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private ILanguageDao languageDao;

    @Transactional(readOnly = false, rollbackFor = DatabaseException.class, propagation = Propagation.REQUIRES_NEW)
    public void add(Category category) throws InternalErrorException {
        try {
            for (Language language : category.getLanguages()) {
                languageDao.add(language);
            }
            category.setCreationDate(new Date());
            categoryDao.add(category);
        } catch (DatabaseException e) {
            throw new InternalErrorException(e);
        }
    }

    @Transactional(readOnly = true)
    public List<Category> get(Long parentId) throws InternalErrorException {
        try {
            if (parentId == null) {
                return categoryDao.get();
            } else {
                return categoryDao.getByParentId(parentId);
            }
        } catch (DatabaseException e) {
            throw new InternalErrorException(e);
        }
    }

    @Transactional(readOnly = true)
    public Category getById(long categoryId) throws InternalErrorException{
        try {
            return categoryDao.getById(categoryId);
        } catch (DatabaseException e) {
            throw new InternalErrorException(e);
        }
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void edit(Category category) throws InternalErrorException {
        try {
            for (Language language : category.getLanguages()) {
                languageDao.edit(language);
            }
        } catch (DatabaseException e) {
            throw new InternalErrorException(e);
        }
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void delete(long categoryId) throws InternalErrorException, EntityNotFoundException {
        try {
            Category category = categoryDao.getById(categoryId);
            if (category == null) {
                throw new EntityNotFoundException();
            }
            languageDao.delete(category.getLanguages());
            categoryDao.delete(categoryId);
        } catch (DatabaseException e) {
            throw new InternalErrorException(e);
        }
    }
}
