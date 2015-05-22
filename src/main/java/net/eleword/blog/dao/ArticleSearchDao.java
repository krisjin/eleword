package net.eleword.blog.dao;

import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
public interface ArticleSearchDao {
    public Pagination<Articles> selectArticleIndexWithPage(Pagination<Articles> page);
}

