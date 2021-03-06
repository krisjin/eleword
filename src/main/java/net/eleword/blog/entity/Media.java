package net.eleword.blog.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author krisjin
 * @date 2014-4-21下午1:55:10
 */
@Entity
@Table(name = "media")
public class Media extends IdEntity {

    private static final long serialVersionUID = -6036205385242273137L;

    private String name;

    private String url;

    private int status;

    private Date createDate;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "status")
    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public int getStatus() {
        return status;
    }

}
