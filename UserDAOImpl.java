package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;


@Repository("userdao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory){
		
	this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Transactional
	public User get(String id) {
		// TODO Auto-generated method stub
		String hql = "from User where id=" + "'"+ id +"'";
		
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
		
	}

	@Transactional
	public String isValidUser(String id, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		for(User u:list)
		{
			String type=u.getUtype();
			System.out.println(type);		
				
		}
		if (list != null && !list.isEmpty()) {
		
			for(User u:list)
			if(u.getUtype().equals("admin"))		
			{return "admin";}
			else
			{return "user";
			}
				
		}
		
		return "invalid";
	}

}

