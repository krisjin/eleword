package net.eleword.blog.service;

import net.eleword.blog.dao.CommentDao;
import net.eleword.blog.entity.Comment;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-13上午11:52:11
 */
@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;

	public long saveComment(Comment entity) {

		return commentDao.add(entity);
	}

	public Pagination<Comment> selectCommentWithPage(Pagination<Comment> page, long articleId) {

		return commentDao.selectCommentWithPageById(page, articleId);

	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

}
