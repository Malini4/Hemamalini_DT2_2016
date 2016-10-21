package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.dao.*;
import com.niit.shoppingcart.model.*;


public class CategoryTest {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
		
		
		
	   /*CategoryDAO categoryDAO = 	(CategoryDAO) context.getBean("CategoryDAO");
	   
	   Category category = 	(Category) context.getBean("Category");
	   category.setId("2");
	   category.setName("WOMEN");
	   
	   
	   
	   categoryDAO.saveOrUpdate(category);
*/		
	   
	   
		/*SupplierDAO supplierDAO = 	(SupplierDAO) context.getBean("supplierDAO");
		   
		   Supplier supplier = 	(Supplier) context.getBean("supplier");
		   supplier.setId("2");
		   supplier.setName("AUREILA");
		   supplier.setAddress("US");
		   
		   
		   supplierDAO.saveorupdate(supplier);
		   */
		
		
		
		
		
		   
					UserDAO userdao= (UserDAO) context.getBean("userdao");
					User user= (User) context.getBean("user");
					
					user.setId("01");
					user.setUsername1("JHON");
					user.setUsername2("PETER");
					user.setUtype("user");
					user.setEmail("example@gmail.com");
					user.setPassword("password");
					user.setAddress("US");
					user.setPhno("123456789");
					
					userdao.saveOrUpdate(user);
					
					/*String type=userdao.isValidUser("usr001", "password");
					if(type=="user"){
						System.out.println("valid user");
						
					}
					else{System.out.println("invalid user");}
				 */
		   
		   
		   
		   
		   
		
		
		
		
		/*ProductDAO productDAO=(ProductDAO)context.getBean("ProductDAO");
		Product product=new Product();
		product.setId("2");
		product.setName("AURELIA");
		product.setCategory("1");
		product.setSupplier("1");
		product.setPrice("1999");
		product.setDesc("SAREE");
		productDAO.saveorupdate(product);*/
		   
		   
	   
	
	}

}
