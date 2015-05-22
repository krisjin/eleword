package net.eleword.blog.search;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-4-23下午5:10:33
 */

public interface Index<T> {

    void create(List<T> entity, String path);

    void update(List<T> entity, String path);

    void delete(List<T> entity, String path);

}

