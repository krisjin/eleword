package net.eleword.blog.test;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-1-26上午11:15:24
 */

public class ExportDbTest {
	private static Session session = null;

	@BeforeClass
	public static void beforeClass() throws Exception {

		session = new AnnotationConfiguration().configure().buildSessionFactory().getCurrentSession();
	}

	@Test
	public void createTable() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}

}
