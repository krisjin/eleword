package net.eleword.blog.dao.impl;

import java.util.List;

import net.eleword.blog.dao.CommentDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Comment;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Repository;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-13上午11:40:05
 */
@Repository("commentDao")
public class CommentDaoImpl extends HibernateDao<Comment, Long> implements CommentDao {

	public Long add(Comment entity) {

		return (Long) save(entity);
	}

	public void update(Comment entity) {

	}

	public void deleteById(long id) {
		delete(id);

	}

	public Comment select(long id) {

		return null;
	}

	public Pagination<Comment> selectCommentWithPageById(Pagination<Comment> page, long articleId) {

		String hql = "from Comment comt where comt.articleId=? order by comt.commentDate asc";
		return findPage(page, hql, articleId);
	}

	public Pagination<Comment> selectCommentWithPage(Pagination<Comment> page) {
		String hql = "from Comment comt order by comt.commentDate asc";
		return findPage(page, hql);
	}

	public List<Comment> selectCommentByArticleId(Long id) {
		String hql = "from Comment where articleId=?";
		return find(hql, id);
	}

}
