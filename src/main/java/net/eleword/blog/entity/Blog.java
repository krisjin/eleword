package net.eleword.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-1-26上午11:13:18
 */
@Entity
@Table(name = "blog")
public class Blog extends IdEntity implements Serializable {

    private static final long serialVersionUID = 6723701217836461499L;

    private String title;

    private String description;

    private String background;

    private int article_num;

    private boolean mail_notice;

    private boolean phone_notice;

    private String banner_color;

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Column
    public int getArticle_num() {
        return article_num;
    }

    public void setArticle_num(int article_num) {
        this.article_num = article_num;
    }

    @Column
    public boolean isMail_notice() {
        return mail_notice;
    }

    public void setMail_notice(boolean mail_notice) {
        this.mail_notice = mail_notice;
    }

    @Column
    public boolean isPhone_notice() {
        return phone_notice;
    }

    public void setPhone_notice(boolean phone_notice) {
        this.phone_notice = phone_notice;
    }

    @Column
    public String getBanner_color() {
        return banner_color;
    }

    public void setBanner_color(String banner_color) {
        this.banner_color = banner_color;
    }

}
