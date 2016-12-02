package com.shevelev.hibernate;

import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DeviceDAO {
	private final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Device> findAll(){
		 Session session = null;
         List<Device> d = new ArrayList<Device>();
         try {
        	 session = sf.openSession();
             d = session.createCriteria(Device.class).addOrder(Order.asc("name")).list();
         } catch (Exception e) {
        	 e.printStackTrace();
         } 
         return d;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public  List<Device> Sample(String name,String state){
		 Session session = null;
        List<Device> d = new ArrayList<Device>();
        try {
       	 session = sf.openSession();
           d = session.createCriteria(Device.class).add(Restrictions.like("name",name)).add(Restrictions.like("state",state)).addOrder(Order.asc("numer")).list();
        } catch (Exception e) {
       	 e.printStackTrace();
        } 
        return d;
	}
		
	public Device find(String id){
		Session session = null;
		Device d = null;
		 try {
             session = sf.openSession();
             d = (Device) session.get(Device.class, id);
         } catch (Exception e) {
        	 e.printStackTrace();
         }
             return d;
         }

	
	public boolean delete(Device dv) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(dv);
			sf.getCurrentSession().getTransaction().commit();
			return true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sf.getCurrentSession().getTransaction().rollback();
			return false;
		}
	}
	
	public boolean save(Device dv){
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(dv);
			sf.getCurrentSession().getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sf.getCurrentSession().getTransaction().rollback();
			return false;
		}
	}
	
	public boolean update(Device tk) {
		   
        try {
        	sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(tk);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }      
	}
}
