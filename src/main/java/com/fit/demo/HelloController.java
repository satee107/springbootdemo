package com.fit.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController  
public class HelloController {
	
	@Autowired  
	private ServiceDemo service;  
	
	@Autowired
    Dao dao;

	//http://localhost:8888/hello-world1?name=sateesh
	@RequestMapping(method=RequestMethod.GET, path="/hello-world1")  
	public String helloWorld1(@RequestParam("name") String name) 
	{  
	return "Hello World and welcome to "+service.getName(name);  
	} 
	
	//http://localhost:8888/hello-world2/sateesh
	@RequestMapping(method=RequestMethod.GET, path="/hello-world2/{name}")  
	public String helloWorld2(@PathVariable("name") String name)  
	{  
	return "Hello World and welcome to "+name;  
	} 
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-worldbean")  
	public Bean helloWorldbean()  
	{  
		Bean bean = new Bean();
		bean.setMsg("hi welcome to spring boot");
		return  bean;
	} 
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-worldbeans")  
	public List<Bean> helloWorldbeans()  
	{  
		List<Bean> list = new ArrayList<Bean>();
		Bean bean1 = new Bean();
		bean1.setMsg("1 welcome to spring boot");
		Bean bean2 = new Bean();
		bean2.setMsg("2 welcome to spring boot");
		
		list.add(bean1);
		list.add(bean2);
		
		return  list;
	} 
	@PostMapping("/hello-worldpost")  
	public String helloWorldpost()  
	{  
	return "Hello World and welcome to post method";  
	} 
	
	@PostMapping("/hello-worldpost1")  
	public String helloWorldpost1(@RequestBody String msg)  
	{  
	return "Hello World and welcome to post method and " +msg;  
	} 
	
	@PostMapping("/hello-worldpost2")  
	public String helloWorldpost2(@ModelAttribute Bean bean)  
	{  
	return "Hello World and welcome to post method and " +bean.getMsg();  
	} 
	
	@GetMapping("/getAllmessages")
	public List<Bean> getAllNotes() {
	    return dao.findAll();
	}
	
	
	@PostMapping("/insertmessage")
	public Bean createBean(@ModelAttribute Bean bean) {
	    return dao.save(bean);
	}
	
	
	@GetMapping("/getMessage/{id}")
	public Optional<Bean> getBeanById(@PathVariable(value = "id") int id) {
	    return dao.findById(id);
	           
	}
	
	
	@DeleteMapping("/deleteMessage/{id}")
	public String deleteNote(@PathVariable(value = "id") int id) {

	    dao.deleteById(id);
System.out.println("deleted");
	    return "successfully deleted";
	}
	
	
	
}
