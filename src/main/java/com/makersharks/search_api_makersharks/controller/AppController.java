package com.makersharks.search_api_makersharks.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.makersharks.search_api_makersharks.beans.Supplier;
import com.makersharks.search_api_makersharks.beans.User;
import com.makersharks.search_api_makersharks.repository.UserRepository;
import com.makersharks.search_api_makersharks.service.SupplierService;
import com.makersharks.search_api_makersharks.service.SecurityService;
import com.makersharks.search_api_makersharks.exception.PageNotFoundException;
import com.makersharks.search_api_makersharks.exception.TaskNotFoundException;
import com.makersharks.search_api_makersharks.exception.UnableToSaveException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AppController {
	@Autowired
	private SupplierService service;
	
	 	
	@GetMapping({"/"})
	public String viewHomePagee(Model model, @Param("keyword") String keyword) throws PageNotFoundException{
		List<Supplier> supplierlist = service.listAll(keyword);
		int totalSupplier = supplierlist.size();
		model.addAttribute("totalSupplier", totalSupplier);
		model.addAttribute("supplierlist", supplierlist);
		model.addAttribute("keyword", keyword);	
		return "index";
	}
	
	@GetMapping("/index")
	public String viewHomePage1(Model model, @Param("keyword") String keyword) {
		List<Supplier> supplierlist = service.listAll(keyword);
		model.addAttribute("supplierlist", supplierlist);
		model.addAttribute("keyword", keyword);
		
		return "index";
	}
	@RequestMapping("/supplierlist")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Supplier> supplierlist = service.listAll(keyword);
		int totalSupplier = supplierlist.size();
		model.addAttribute("totalSupplier", totalSupplier);
		model.addAttribute("supplierlist", supplierlist);
		model.addAttribute("keyword", keyword);	
		return "/supplierlist";
	}
	
	
	
	
	@GetMapping("/api/supplier/new_supplier")
	public String showNewProductForm(Model model)  throws TaskNotFoundException {
		Supplier supplier = new Supplier();
	model.addAttribute("supplier", supplier);
		
		return "/new_supplier";
	
	
	}
	

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("supplierlist") Supplier supplierlist) throws UnableToSaveException{
		service.save(supplierlist);
		
		return "redirect:/supplierlist";
	}
	

	
	@RequestMapping("/api/supplier/edit/{supplier_id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "supplier_id") Long supplier_id) {
		ModelAndView mav = new ModelAndView("edit_supplier");
		
		Supplier supplier = service.get(supplier_id);
		mav.addObject("supplier", supplier);
		return mav;
	}	
	
	@RequestMapping("/api/supplier/delete/{supplier_id}")
	public String deleteProduct(@PathVariable(name = "supplier_id") Long supplier_id) {
		service.delete(supplier_id);
		
		return "redirect:/supplierlist";
	}
	
	///======================================================================
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping({"/login"})
	public String login() {
		return "login";
		}

	
	@PostMapping("/login")
	public String longinresponse(String email, String password,HttpServletRequest request, HttpServletResponse response) {
		boolean loginResponse = securityService.longin(email, password,request, response);

		if(loginResponse) {
			return "/supplierlist";
		}
		return "login";
		
	}
		
	@GetMapping("/registration")
	public String registration() {
		return "registration";
		}
	
	@PostMapping("/registration")
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login";
		}


}
