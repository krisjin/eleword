package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.MediaDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Media;
import net.eleword.blog.util.Pagination;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
@Repository("mediaDao")
public class MediaDaoImpl extends HibernateDao<Media, Long> implements MediaDao {

    public Long add(Media entity) {

        return (Long) save(entity);
    }

    public void update(Media entity) {
        Query query = createQuery("update Media set name=? ,url=?,status=?  where id=?", entity.getName(), entity.getUrl(), entity.getStatus(), entity.getId());
        query.executeUpdate();
    }

    public void deleteById(long id) {
        delete(id);
    }

    public Media select(long id) {

        return get(id);
    }

    public Pagination<Media> selectMediaWithPage(Pagination<Media> page, int status) {
        String hql = "";
        ;
        if (status == 3) {
            hql = "from Media m  order by m.createDate desc";
        } else {
            hql = "from Media m  where m.status =" + status + " order by m.createDate desc";
        }
        return findPage(page, hql);
    }

    public List<Media> getAllMedia() {

        return getAll();
    }

}
