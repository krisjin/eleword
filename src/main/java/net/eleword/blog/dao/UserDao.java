package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.User;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-12下午1:40:38
 */

public interface UserDao extends BaseDao<User> {
	User selectUserByName(String name);
}

