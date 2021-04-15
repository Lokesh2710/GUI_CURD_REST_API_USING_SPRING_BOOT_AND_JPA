package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@PostMapping("/addAlien")
	/*public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	  //Commented it to just check with another method function with same url(postman)
	  
	/*@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByAidGreaterThan(105));
//		System.out.println(repo.findByTechSorted("java"));

		
		mv.addObject(alien);
		return mv;
	}
	*/ // becoz i need to check it with postman
	
	//Postman operation implementation
	
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien SaveOrUpdateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	

	/*@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(Alien alien)
	{
		ModelAndView mv1 = new ModelAndView("showAlien.jsp");
		Alien existingAlien = repo.findById(alien.getAid()).orElse(null);
		existingAlien.setAname(alien.getAname());
		existingAlien.setTech(alien.getTech());
		repo.save(existingAlien);
		mv1.addObject(existingAlien);
		return mv1;
	}*/ //postman se check krna tha isliye hta dia
	
	/*@RequestMapping("deleteAlien")
	public String deleteStudent(@RequestParam int aid)
	{
		repo.deleteById(aid);
		//String res =  "Student Having "+aid+" Deleted ";
		//return res;
		return "home.jsp";
		
	}*///Comments kyuki ek bar postman se bhi check krna hai 
	
	/*find by name/tech /
	
	@RequestMapping("/getAlienByTech")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}*/
	
	//delete by postman 
	@DeleteMapping("/aliens/{aid}")
	public String deleteAlien(@PathVariable int aid)
	{
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted";
	}
	
	/*@GetMapping(path="/aliens")
	public List<Alien> getAliens()
	{
		return repo.findAll();	
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/aliens/{aid}")
	public Optional<Alien> getAliensTR(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);	
	}*/
}
