package net.eleword.blog.dao.impl;

import java.util.List;

import net.eleword.blog.dao.ColorDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Color;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Repository;

/**
 * 颜色表数据访问层实现
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-3-13下午12:37:59
 */
@Repository("colorDao")
public class ColorDaoImpl extends HibernateDao<Color, Long> implements ColorDao {

	public Long add(Color entity) {
		return (Long) save(entity);
	}

	public void update(Color entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public Color select(long id) {
		return get(id);
	}

	public Pagination<Color> selectColorWithPage(Pagination<Color> page) {

		return findPage(page);
	}

	public Color selectColorByCode(String code) {
		return findUniqueBy("code", code);
	}

	public List<Color> getAllColors() {
		return getAll();
	}

}
