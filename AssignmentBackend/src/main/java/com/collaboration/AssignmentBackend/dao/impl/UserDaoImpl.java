package com.collaboration.AssignmentBackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.AssignmentBackend.dao.UserDao;
import com.collaboration.AssignmentBackend.model.User;


@Repository("userDao")
public class UserDaoImpl implements UserDao {


	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	User user;


	public UserDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
	//	log.debug("start");
		this.sessionFactory=sessionFactory;
		
	}

	
	@Transactional
	public boolean save(User user) {
		//log.debug("Starting of the method  save");
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(User user) {
		
		//log.debug("calling update method");
		try{
			//log.debug("Open new session");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	public User get(String id) {
			//log.debug("Starting of the method  get with the id :"+ id);
		
		user =	(User)sessionFactory.getCurrentSession().get(User.class, id);
		
		//log.debug("user:" + user);
				return user;

	}

	@Transactional
	public List<User> list() {
		//log.debug("Starting of the method  list");
		String hql = "from User";
		
		Query query=  sessionFactory.getCurrentSession().createQuery(hql);
		//log.debug("Ending of the method  TUserDAOImpl");
		return  query.list();

	}


	public User validate(String id, String password) {
		//log.debug("Starting of the method  validate");
		
		String hql = "from User  where id= '" + id +"' and password = '" + password+"'";
		
		Query query=  sessionFactory.getCurrentSession().createQuery(hql);
		//log.debug("Ending of the method  TUserDAOImpl");
		return  (User)query.uniqueResult();

	}
}
