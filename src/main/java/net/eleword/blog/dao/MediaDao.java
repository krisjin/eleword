package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Media;
import net.eleword.blog.util.Pagination;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
public interface MediaDao extends BaseDao<Media> {

    Pagination<Media> selectMediaWithPage(Pagination<Media> page, int status);

    List<Media> getAllMedia();
}

