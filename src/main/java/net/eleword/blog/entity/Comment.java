package net.eleword.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date  2014-1-26上午11:13:51
 */
@Entity
@Table
public class Comment extends IdEntity implements Serializable {

	private static final long serialVersionUID = -3374963390660032076L;
	
	private String commentUser;
	
	private String commentContent;
	
	private Date  commentDate;
	
	private String email;
	
	private long articleId;
	
	
}

