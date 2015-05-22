package net.eleword.blog.search.task;

import net.eleword.blog.search.Index;
import net.eleword.blog.search.IndexHolder;
import net.eleword.blog.search.entity.Articles;

import java.io.IOException;
import java.util.List;

/**
 * 文章索引操作
 *
 * @author krisjin
 * @date 2014-4-22下午2:04:45
 */

public class ArticleIndex implements Index<Articles> {

    public void create(List<Articles> entity, String indexPath) {
        try {
            IndexHolder holder = IndexHolder.init(indexPath);
            holder.add(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update(List<Articles> entity, String path) {

        try {
            IndexHolder holder = IndexHolder.init(path);
            holder.update(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delete(List<Articles> entity, String path) {

    }

}
