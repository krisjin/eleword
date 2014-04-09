package net.eleword.blog.service;

import net.eleword.blog.dao.UserDao;
import net.eleword.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-12下午3:08:25
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User selectUserByName(String name) {
		return userDao.selectUserByName(name);
	}

	public void updatePassword(User user) {
		userDao.update(user);
	}

	public void saveOrUpateUserAvatar(User user) {

		userDao.update(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
