package net.eleword.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-3-13上午10:28:10
 */

@Entity
@Table(name = "color")
public class Color extends IdEntity implements Serializable {

    private static final long serialVersionUID = 2679116607447263872L;

    private String name;

    private String description;

    private String code;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
