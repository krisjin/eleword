package net.eleword.blog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-26上午11:13:18
 */
@Entity
@Table(name = "blog")
public class Blog extends IdEntity implements Serializable {

	private static final long serialVersionUID = 6723701217836461499L;
	
	private String title;
	
	private String description;

	private String background;

	private int articleNum;

	private boolean mailNotice;

	private boolean phoneNotice;
	
	@Column(name="title",nullable=false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="background")
	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}
	
	@Column(name="articleNum",nullable=false)
	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	
	@Column(name="mailNotice", nullable=false)
	public boolean isMailNotice() {
		return mailNotice;
	}

	public void setMailNotice(boolean mailNotice) {
		this.mailNotice = mailNotice;
	}
	
	@Column(name="phoneNotice",nullable=false)
	public boolean isPhoneNotice() {
		return phoneNotice;
	}

	public void setPhoneNotice(boolean phoneNotice) {
		this.phoneNotice = phoneNotice;
	}

}
