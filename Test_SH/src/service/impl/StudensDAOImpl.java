package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudensDAO;

public class StudensDAOImpl implements StudensDAO{

	@Override
	public List<Students> queryAllStudents() {
		Transaction tx=null;
		String hql="";
		List<Students> list=null;
		try {
			
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			
			tx=session.beginTransaction();
			
			hql="from Students";
			Query query=session.createQuery(hql);
			
			list= query.list();
			tx.commit();//提交事务
			return list;
		
		} catch (Exception e) {
		e.printStackTrace();
		tx.commit();
			return list;
	}
		finally{
			if (tx!=null) {
				tx=null;
			}
		}
}
		
	

	@Override
	public Students queryStudentsBySid(String sid) {

		Transaction tx=null;
	
		Students s=null;
		try {
			
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			
			tx=session.beginTransaction();
			
			s=(Students)session.get(Students.class, sid);
			
		
			tx.commit();//提交事务
			return s;
		
		} catch (Exception e) {
		e.printStackTrace();
		tx.commit();
			return s;
	}
		finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean addStudents(Students s) {
		Transaction tx=null;
		s.setSid(getNewSid());
		try {
			
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			
			tx=session.beginTransaction();
			session.save(s);
			//hql="from Students where Sid=?";
			//Query query=session.createQuery(hql);
			tx.commit();//提交事务
			return true;
		
		} catch (Exception e) {
		e.printStackTrace();
		tx.commit();
			return false;
	}
		finally{
			if (tx!=null) {
				tx=null;
			}
		}
		
	}

	@Override
	public boolean updateStudent(Students s) {
		Transaction tx=null;
		String hql="";
			try {
			
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();//提交事务
			return true;
		
		} catch (Exception e) {
		e.printStackTrace();
		tx.commit();
			return false;
	}
		finally{
			if (tx!=null) {
				tx=null;
			}
		}
		
		
	
	}

	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx=null;
		//String hql="";
		try {
			
			Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			
			tx=session.beginTransaction();
			Students s=(Students)session.get(Students.class, sid);
			session.delete(s);
			//hql="from Students where Sid=?";
			//Query query=session.createQuery(hql);
			tx.commit();//提交事务
			return true;
		
		} catch (Exception e) {
		e.printStackTrace();
		tx.commit();
			return false;
	}
		finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}
public String getNewSid(){
	Transaction tx=null;
	String hql="";
	String sid=null;
			try {
				
				Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
				
				tx=session.beginTransaction();
			
				hql="select max(sid) from Students";
				Query query=session.createQuery(hql);
				sid=(String)query.uniqueResult();
				if ("".equals(sid)||sid==null) {
					sid="S100001";
				} else {
					String temp=sid.substring(1);//取后6位
					int i= Integer.parseInt(temp);//转换为数字
					i++;
					temp=String.valueOf(i);//转换为String
					int len=temp.length();
					//凑够六位
					for (int j = 0; j < 6-len; j++) {
						temp="0"+temp;
					}
					//标准ID
					sid="S"+temp;
				}
				tx.commit();//提交事务
				return sid;
			
			} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
				return sid;
		}
			finally{
				if (tx!=null) {
					tx=null;
				}
			}
		}
}	
	

