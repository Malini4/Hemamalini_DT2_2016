package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")

@Component
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory){
		
		this.sessionFactory=sessionFactory;
		
	}
	
	
	@Transactional
	public void saveorupdate(Supplier supplier)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}
	
	@Transactional
	public void delet(String id){
		Supplier supplier=new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
		
	}
	@Transactional
	public Supplier get(String id){
		String hql = "from Supplier where id=" + "'"+ id +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}
		
		@Transactional
		public List<Supplier> list() {
			@SuppressWarnings("unchecked")
			List<Supplier> listSupplier = (List<Supplier>) 
			          sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listSupplier;
		}

		
		
}
