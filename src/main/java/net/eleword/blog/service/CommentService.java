package net.eleword.blog.service;

import net.eleword.blog.dao.CommentDao;
import net.eleword.blog.entity.Comment;
import net.eleword.blog.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-2-13上午11:52:11
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public long saveComment(Comment entity) {
        return commentDao.add(entity);
    }

    public Pagination<Comment> selectCommentWithPageByArticleId(Pagination<Comment> page, long articleId) {
        return commentDao.selectCommentWithPageById(page, articleId);
    }

    public Pagination<Comment> selectCommentWithPage(Pagination<Comment> page) {
        return commentDao.selectCommentWithPage(page);
    }

    public void deleteById(long id) {
        commentDao.deleteById(id);
    }

    public List<Comment> selectCommentByArticleId(Long id) {
        return commentDao.selectCommentByArticleId(id);
    }

}
