package net.eleword.blog.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
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
	
	@Column(name="title",nullable = false)
	public String getTitle() {
		return title;
	}

	@Column(name="content",nullable = false)
	public String getContent() {
		return content;
	}

	@Column(name="keywords")
	public String getKeywords() {
		return keywords;
	}

	@Column(name="post_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPostDate() {
		return postDate;
	}

	@Column(name="modify_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyDate() {
		return modifyDate;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}
	@Column(name="author",nullable = false)
	public String getAuthor() {
		return author;
	}
	
	@Column(name="category_id")
	public long getCategoryId() {
		return categoryId;
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
	
	@Column
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

}
