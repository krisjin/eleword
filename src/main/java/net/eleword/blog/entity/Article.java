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

	private Category categoryId;

	private long userId;

	private int status;

	private int views;

	@Column(nullable = false)
	public String getTitle() {
		return title;
	}

	@Column
	public String getContent() {
		return content;
	}

	@Column
	public String getKeywords() {
		return keywords;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPostDate() {
		return postDate;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyDate() {
		return modifyDate;
	}
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name="categoryId")
	public Category getCategoryId() {
		return categoryId;
	}

	@Column(nullable = false)
	public long getUserId() {
		return userId;
	}

	@Column(nullable = false)
	public int getStatus() {
		return status;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
