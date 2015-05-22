package net.eleword.blog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-1-26上午11:13:51
 */
@Entity
@Table(name = "comment")
public class Comment extends IdEntity implements Serializable {

    private static final long serialVersionUID = -3374963390660032076L;

    private String commentUser;

    private String commentContent;

    private String commentNickname;

    private Date commentDate;

    private String email;

    private long articleId;

    private String articleTitle;

    @Column(name = "comment_user")
    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    @Column(name = "comment_content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Column(name = "comment_nickname")
    public String getCommentNickname() {
        return commentNickname;
    }

    public void setCommentNickname(String commentNickname) {
        this.commentNickname = commentNickname;
    }

    @Column(name = "comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "article_id")
    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    @Transient
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

}
