package net.eleword.blog.search;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date  2014-4-23下午5:12:28
 */

public interface Search<T> {
	
	List<T> searche(T entity);
}

