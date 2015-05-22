package net.eleword.blog.service;

import net.eleword.blog.dao.CategoryDao;
import net.eleword.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-1-27上午10:13:09
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public long add(Category category) {
        return categoryDao.add(category);
    }

    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }

    public void deleteByCategoryId(Long id) {
        categoryDao.deleteById(id);
    }

    public Category selectCategoryById(Long id) {
        return categoryDao.select(id);

    }

    public void update(Category category) {
        categoryDao.update(category);
    }

    public void updateArticleNumber(Category category) {
        categoryDao.updateArticleNumber(category);
    }
}
