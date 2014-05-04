package net.eleword.blog.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Entity
@Table(name = "file")
public class File extends IdEntity implements Serializable {

	private static final long serialVersionUID = 221258502106073606L;
	
	private String name;
	private String summary;
	private long size;
	
}
