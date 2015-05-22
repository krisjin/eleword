package net.eleword.blog.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
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

    private Long folderId;

    /**
     * 0:无效；1有效 Comment for <code>status</code>
     */
    private int status;

    private String media;

    private String mediaUrl;

    private String thumbnailsUrl;

    private String author;

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "post_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "media")
    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    @Column(name = "media_url")
    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    @Column(name = "thumbnails_url")
    public String getThumbnailsUrl() {
        return thumbnailsUrl;
    }

    public void setThumbnailsUrl(String thumbnailsUrl) {
        this.thumbnailsUrl = thumbnailsUrl;
    }

    @Column(name = "folder_id", columnDefinition = "bigint(20)  default 0 ")
    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }


}
