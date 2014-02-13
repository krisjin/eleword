package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Comment;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date  2014-2-13上午11:39:28
 */

public interface CommentDao extends BaseDao<Comment>{
	
	Pagination<Comment> selectCommentWithPageById(Pagination<Comment> page,long articleId);
	
}

