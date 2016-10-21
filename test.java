package com.niit.shoppingcart.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;
import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;;
@Controller
public class test{
	
@Autowired
UserDAO userdao;
@Autowired
CategoryDAO categoryDAO;


@Autowired
ProductDAO productDAO;

@Autowired
User user;

@Autowired
SupplierDAO supplierDAO;


	


	@RequestMapping("look")
	public ModelAndView toLogin(){
	return new ModelAndView("register");
}

@RequestMapping("look1")
	public ModelAndView toIndianwear(){
	return new ModelAndView("indianwear");
}

@RequestMapping("look2")
public ModelAndView toWesternwear(){
return new ModelAndView("westernwear");
}
	

@RequestMapping("look3")
public ModelAndView toCasuals(){
return new ModelAndView("casuals");
}

@RequestMapping("look4")
public ModelAndView toFormals(){
return new ModelAndView("formals");
}

@RequestMapping("look5")
public ModelAndView toContact(){
return new ModelAndView("contact");
}


@RequestMapping("/adminHome")
public ModelAndView toAdminHome(){
return new ModelAndView("adminHome");
}

@RequestMapping("/kill")
public ModelAndView toAdd(){
return new ModelAndView("add");
}

@RequestMapping("/die")
public ModelAndView toAddpro(){
return new ModelAndView("addpro");
}


@RequestMapping("/live")
public ModelAndView toAddsupp(){
return new ModelAndView("addsupp");
}




	
	 @RequestMapping(value="/isValidUser",method=RequestMethod.POST)
	 public ModelAndView executeLogin(@RequestParam("userid") String uid,@RequestParam("pass") String pwd){

		 
		 ModelAndView mv;
		
		 String type=userdao.isValidUser(uid, pwd);
	 System.out.println(type);
		if(type.equals("user")){mv=new ModelAndView("Indianwear");
}
		else if(type.equals("admin")){
			mv=new ModelAndView("adminHome");			
		} 
		else{
			 mv=new ModelAndView("westernwear");
		 }
	 return mv;}
	 
	 
	 @RequestMapping (value="/savenewcategory")
	 public ModelAndView newcat (@RequestParam("id") String id,@RequestParam("name") String name){
		 Category cat=new Category();
		 cat.setId(id);
		 cat.setName(name);
		 categoryDAO.saveOrUpdate(cat);
		 
		 ModelAndView mv;
		 return new ModelAndView("Cat");
		 
		 
	 }
	 
	 
	 @RequestMapping (value="/savenewsupplier")
	 public ModelAndView newsupp (@RequestParam("id") String id,@RequestParam("name") String name){
		 Supplier supp=new Supplier();
		 supp.setId(id);
		 supp.setName(name);
		 supplierDAO.saveorupdate(supp);
		 
		 ModelAndView mv;
		 return new ModelAndView("Cat");
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 @RequestMapping (value="/savenewproduct")
	 public ModelAndView newpro (@RequestParam("id") String id,@RequestParam("name") String name){
		 Product pro=new Product();
		 pro.setId(id);
		 pro.setName(name);
		 productDAO.saveOrUpdate(pro);
		 
		 ModelAndView mv;
		 return new ModelAndView("Products");
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping("adm")
		public ModelAndView toAdmin(){
			return new ModelAndView("adminhome");
	 }
	 
	 
	 @RequestMapping("/allCat")
	 public ModelAndView toCat()
	 {
	 return new ModelAndView("Cat");
	 }

	 @RequestMapping("/allUser")
	 public ModelAndView toUser()
	 {
	 return new ModelAndView("User");
	 }

	 @RequestMapping("/allProd")
	 public ModelAndView toProducts()
	 {
	 return new ModelAndView("Products");
	 }

	 @RequestMapping("/allSupp")
	 public ModelAndView toSupp()
	 {
	 return new ModelAndView("supp");
	 }

	 
	 

	 @RequestMapping("/dispProd")
	 public @ResponseBody String dispProd()
	 {
	 List<Product> listProd=productDAO.list();

	 Gson g=new Gson();
	 String Products=g.toJson(listProd);


	 return Products;   
	 }



	 @RequestMapping("/dispsupp")
	 public @ResponseBody String dispSupp()
	 {
	 List<Supplier> listSupplier=supplierDAO.list();

	 Gson g=new Gson();
	 String supp=g.toJson(listSupplier);


	 return supp;   
	 }

	 
	 
	 

	 @RequestMapping("/dispUser")
	 public @ResponseBody String dispUser()
	 {
	 List<User> listUser=userdao.list();

	 Gson g=new Gson();
	 String User=g.toJson(listUser);

	 for(User u:listUser){
	 	
	 	System.out.println(u.getId());
	 	System.out.println(u.getUsername1());
	 	System.out.println(u.getUtype());
	 	System.out.println(" next ");
	 }

	 return User;
	 }







	 @RequestMapping("/dispCat")
	 public @ResponseBody String dispCategory()
	 {
	 List<Category> listCategory=categoryDAO.list();

	 Gson g=new Gson();
	 String Cat=g.toJson(listCategory);

	 for(Category u:listCategory){
	 	
	 	System.out.println(u.getId());
	 	System.out.println(u.getName());
	 	
	 	System.out.println(" next ");
	 }

	 return Cat;
	 }
	 

	
	
	
	
	
	
	
	
	

}





