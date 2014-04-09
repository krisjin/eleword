package net.eleword.blog.entity.common;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-26下午2:10:37
 */

public enum ArticleStatus {

	Normal(1), Invalid(2), Private(3);

	private int status;

	private ArticleStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
