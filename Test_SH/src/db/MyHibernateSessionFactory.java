package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;
	
	//构造方法私有化，保证单例模式
	private MyHibernateSessionFactory (){
		
	};
	//公有的静态方法，获得会话工厂对象
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory==null){
			
			Configuration config =new Configuration().configure();
			System.out.println("xiaoyama");
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			System.out.println(serviceRegistry.toString());
			System.out.println("----------------------------");
			sessionFactory=config.buildSessionFactory(serviceRegistry);
			System.out.println(sessionFactory.toString());
			
			return sessionFactory;
		}
		else{
			return sessionFactory;
		}
	}
}
