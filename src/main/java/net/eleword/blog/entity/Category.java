package net.eleword.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-1-26上午11:13:44
 */
@Entity
@Table(name = "category")
public class Category extends IdEntity implements Serializable {

    private static final long serialVersionUID = -6286083506735445096L;

    private String name;

    private int orderValue;

    private int articleNumber;

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "order_value", nullable = true)
    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    @Column(name = "article_number", nullable = true)
    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

}
