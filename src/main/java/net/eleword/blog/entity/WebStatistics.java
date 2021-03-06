package net.eleword.blog.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
@Entity
@Table(name = "webstatistics")
public class WebStatistics extends IdEntity {

    private static final long serialVersionUID = 1L;

    private String ip;

    private String url;

    private Date date;

    private String address;


    @Transient
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public WebStatistics() {
    }

    public WebStatistics(String ip, String url, Date date) {
        this.ip = ip;
        this.url = url;
        this.date = date;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
