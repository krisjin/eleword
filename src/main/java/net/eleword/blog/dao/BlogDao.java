package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Blog;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
public interface BlogDao extends BaseDao<Blog> {

    public List<Blog> getAllBlogConfig();

}
