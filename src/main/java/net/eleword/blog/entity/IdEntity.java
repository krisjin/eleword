package net.eleword.blog.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author krisjin
 * @date 2014-1-26上午11:18:34
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {

    private static final long serialVersionUID = 7102470486904089473L;
    protected long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
