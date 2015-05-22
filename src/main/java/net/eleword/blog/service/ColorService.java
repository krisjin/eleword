package net.eleword.blog.service;

import net.eleword.blog.dao.ColorDao;
import net.eleword.blog.entity.Color;
import net.eleword.blog.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-3-13下午12:48:06
 */
@Service
public class ColorService {

    @Autowired
    private ColorDao colorDao;

    public void addColor(Color color) {
        colorDao.add(color);
    }

    public void deleteColorById(Long id) {
        colorDao.deleteById(id);
    }

    public Pagination<Color> queryColorWithPage(Pagination<Color> page) {
        return colorDao.selectColorWithPage(page);
    }

    public Color queryColorByCode(String code) {
        return colorDao.selectColorByCode(code);
    }

    public List<Color> queryAllColors() {
        return colorDao.getAllColors();
    }
}
