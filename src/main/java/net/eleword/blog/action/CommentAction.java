package net.eleword.blog.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.eleword.blog.entity.Comment;
import net.eleword.blog.entity.User;
import net.eleword.blog.service.CommentService;
import net.eleword.blog.service.UserService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-13下午12:34:10
 */
@Controller
public class CommentAction {

	private String nickname;
	private String email;
	private String content;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/comments/{id}",method = RequestMethod.POST)
	public String post(
			@PathVariable("id") Long articleId,
			@RequestParam(value="content") String content,
			@RequestParam(value="nickname") String nickname,
			@RequestParam(value="email") String email,
//			@RequestParam(value="articleId") String articleId,
			HttpServletRequest request,HttpServletResponse response
			) {
		
		Comment comment = new Comment();
		comment.setCommentContent(content);
		comment.setCommentDate(new Date());
		comment.setCommentNickname(nickname);
		comment.setEmail(email);
		comment.setArticleId(Long.valueOf(articleId));
		commentService.saveComment(comment);
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		request.setAttribute("avatar", user.getAvatar());
		String path=HttpUtils.getBasePath(request)+"/article/"+articleId+"#comments";
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}
