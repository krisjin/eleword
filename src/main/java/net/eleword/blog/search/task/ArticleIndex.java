package net.eleword.blog.search.task;

import java.io.IOException;
import java.util.List;

import net.eleword.blog.search.Index;
import net.eleword.blog.search.IndexHolder;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 文章索引操作
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-22下午2:04:45
 */

public class ArticleIndex implements Index<Articles> {


	public void create(List<Articles> entity, String indexPath) {
		try {
			IndexHolder index = IndexHolder.init(indexPath);
			index.add(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void update(List<Articles> entity, String path) {

	}

	public void delete(List<Articles> entity, String path) {

	}

}
