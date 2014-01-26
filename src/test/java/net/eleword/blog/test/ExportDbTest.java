package net.eleword.blog.test;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date  2014-1-26上午11:15:24
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
	
	//@Test
//	public void insert(){
//		User user= new User();
//		Date date=new Date();
//		user.setEmail("krisibm@163.com");
//		user.setLastLoginDay(date);
//		user.setName("jingui");
//		user.setRecentLoginTime(date);
//		user.setRegisterDate(date);
//		user.setNickName("zhansan3");
//		
//		session.beginTransaction();
//		session.save(user);
//		session.getTransaction().commit();
//	}
//	
//	@Test
//	public void query(){
//		session.beginTransaction();
//		Query query=session.createQuery("select u.name from User u");
//		List<User> users=(List<User>)query.list();
//		//session.getTransaction().commit();
//		
//		
//		for(int i=0;i<users.size();i++){
////			User u=null;
////			Object obj=users.get(i);
////			if(u instanceof Object){
////				 u=(User)obj;
////				System.out.println("ddd");
////			}
//			
//			System.out.println(users.get(i));
//		}
//		
//		
//	}
	

}

