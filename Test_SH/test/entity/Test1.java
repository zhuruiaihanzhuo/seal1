package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class Test1 {
	
	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new 
				ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionfactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.getCurrentSession();
		SchemaExport export=new SchemaExport(config);
		export.create(true,true);
}
}