package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudent {

	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionfactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.getCurrentSession();
		SchemaExport export=new SchemaExport(config);
		export.create(true,true);
}

	@Test
	public void testSaveStudents(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionfactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.getCurrentSession();
		//创建事务对象
		Transaction tx=session.beginTransaction();
		Students s1=new Students("100056","朱瑞","男",new Date(),"陆集");
		Students s2=new Students("100057","陈丽媛","女",new Date(),"埠子");
		Students s3=new Students("100058","老段","男",new Date(),"陆河");
		Students s4=new Students("100059","刘瑞","男",new Date(),"洋北");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		tx.commit();
		sessionFactory.close();
}
}
