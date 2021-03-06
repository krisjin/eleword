package net.eleword.blog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-1-26上午11:13:03
 */
@Entity
@Table(name = "article")
public class Article extends IdEntity implements Serializable {

    private static final long serialVersionUID = -2795641924523901764L;

    private String title;

    private String content;

    private String keywords;

    private Date postDate;

    private Date modifyDate;

    private String author;

    private int status;

    private int views;

    private long categoryId;

    private String categoryName;

    private List<Comment> comments;

    private int commentCount;

    @Transient
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    @Column(name = "post_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPostDate() {
        return postDate;
    }

    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getModifyDate() {
        return modifyDate;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    @Column(name = "category_id")
    public long getCategoryId() {
        return categoryId;
    }

    @Transient
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Transient
    //@Column
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Transient
    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

}
