package net.eleword.blog.search.task;

import java.io.IOException;
import java.util.List;

import net.eleword.blog.search.Index;
import net.eleword.blog.search.IndexHolder;
import net.eleword.blog.search.entity.Article;

/**
 * 文章索引操作
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-22下午2:04:45
 */

public class ArticleIndex implements Index<Article> {

	public void create(List<Article> entity) {

		try {
			IndexHolder index = IndexHolder.init("e:/Post");
			index.add(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void update(List<Article> entity) {

	}

	public void delete(List<Article> entity) {

	}

}
