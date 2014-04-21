package net.eleword.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-21下午1:55:10
 */
@Entity
@Table(name = "mdiea")
public class Media extends IdEntity {

	private static final long serialVersionUID = -6036205385242273137L;

	private String name;

	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
