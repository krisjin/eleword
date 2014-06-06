package net.eleword.blog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.eleword.blog.dao.UserDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.User;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-2-12下午1:42:06
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDao<User, Long> implements UserDao {

	public Long add(User entity) {
		return null;
	}

	public void update(User entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {

	}

	public User select(long id) {

		return null;
	}

	public User selectUserByName(String name) {
		List<User> userList = findBy("username", name);

		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

}
