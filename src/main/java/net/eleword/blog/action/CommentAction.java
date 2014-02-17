package net.eleword.blog.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Comment;
import net.eleword.blog.service.CommentService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-13下午12:34:10
 */
@Controller("commentAction")
public class CommentAction extends BaseAction {

	private String nickname;
	private String email;
	private String content;
	private String articleId;

	@Autowired
	private CommentService commentService;

	public String post() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Comment comment = new Comment();
		comment.setCommentContent(content);
		comment.setCommentDate(new Date());
		comment.setCommentNickname(nickname);
		comment.setArticleId(Long.valueOf(articleId));
		comment.setEmail(email);
		commentService.saveComment(comment);
		return "viewcomment";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}
