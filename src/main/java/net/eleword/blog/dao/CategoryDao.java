package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Category;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-1-27上午6:09:31
 */
public interface CategoryDao extends BaseDao<Category> {

    List<Category> selectAll();

    void updateArticleNumber(Category entity);
}
