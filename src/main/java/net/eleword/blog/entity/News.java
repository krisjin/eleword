package net.eleword.blog.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-21下午1:49:22
 */

@Entity
@Table(name = "news")
public class News extends IdEntity {

	private static final long serialVersionUID = 3996647811663640302L;

	private String title;

	private String content;

	private String user;

	private Date postDate;

	/**
	 * 0:无效；1有效 Comment for <code>status</code>
	 */
	private short status;

	private String media;

	private String mediaUrl;

	private String thumbnailsUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getThumbnailsUrl() {
		return thumbnailsUrl;
	}

	public void setThumbnailsUrl(String thumbnailsUrl) {
		this.thumbnailsUrl = thumbnailsUrl;
	}

}
