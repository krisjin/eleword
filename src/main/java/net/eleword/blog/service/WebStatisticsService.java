package net.eleword.blog.service;

import net.eleword.blog.dao.WebStatisticsDao;
import net.eleword.blog.entity.WebStatistics;
import net.eleword.blog.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
@Service
public class WebStatisticsService {

    @Autowired
    private WebStatisticsDao webStatisticsDao;

    public void add(WebStatistics ws) {
        webStatisticsDao.add(ws);
    }

    public Pagination<WebStatistics> selectWebStatisticsWithPage(Pagination<WebStatistics> page) {
        return webStatisticsDao.selectWebStatisticsWithPage(page);
    }
}
