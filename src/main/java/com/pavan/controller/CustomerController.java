package com.pavan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pavan.model.CustomerAttendanceBO;
import com.pavan.model.CustomerBO;
import com.pavan.respository.CustomerAttendanceRepository;
import com.pavan.respository.CustomerRepository;

@Controller
@SessionAttributes(names = "currentUser")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAttendanceRepository customerAttendanceRepository;

	@GetMapping("/admin/customers")
	public ModelAndView customers() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer",
		             new CustomerBO());
		mv.addObject("customers",
		             customerRepository.findAll());
		mv.setViewName("customers");
		return mv;
	}

	@PostMapping(value = "/admin/saveCustomer")
	@ResponseBody
	public String saveCustomer(CustomerBO customer) {
		String message = "";
		if (customer.getTotalFee() != null && customer.getFeePaid() != null) {
			customer.setBalance(customer.getTotalFee() - customer.getFeePaid());
		}
		try {
			customerRepository.save(customer);
			message = "SUCCESS-Customer saved successfully.";
		} catch (Exception e) {
			message = "ERROR-" + e.getMessage();
		}
		return message;
	}

	@GetMapping("/admin/updateCustomer")
	public String updateCustomer(@RequestParam(value = "u") CustomerBO u, Model m) {
		m.addAttribute("customer",
		               u == null ? new CustomerBO() : u);
		return "customerPopup";
	}

	@GetMapping("/admin/deleteCustomer")
	public String deleteUser(@RequestParam(value = "u") CustomerBO u) {
		String message = "";
		try {
			customerRepository.delete(u);
			return "redirect:/admin/customers";
		} catch (Exception e) {
			message = "ERROR-" + e.getMessage();
			return message;
		}
	}

	@GetMapping("/admin/attendance")
	public ModelAndView customerAttendance() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers",
		             customerRepository.findAll());
		mv.setViewName("attendance");
		return mv;
	}

	@GetMapping("/admin/customerAttendance")
	public ModelAndView customerAttendance(@RequestParam(value = "customer") CustomerBO customer, Model m) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer",
		             customer);
		mv.addObject("customerAttendance",
		             customerAttendanceRepository.findByCustomer(customer));
		mv.setViewName("customerAttendance");
		return mv;
	}

	@GetMapping("/admin/customerAttendancePopup")
	public String customerAttendance(@RequestParam(value = "u") CustomerAttendanceBO u,
	        @RequestParam(value = "c") CustomerBO c, Model m) {
		m.addAttribute("customerAttendance",
		               u == null ? new CustomerAttendanceBO() : u);
		m.addAttribute("customer",
		               c);
		return "customerAttendancePopup";
	}

	@PostMapping(value = "/admin/saveCustomerAttendance")
	@ResponseBody
	public String saveCustomerAttendance(CustomerAttendanceBO attendance) {
		String message = "";
		try {
			customerAttendanceRepository.save(attendance);
			message = "SUCCESS-Customer Attendance saved successfully.";
		} catch (Exception e) {
			message = "ERROR-" + e.getMessage();
		}
		return message;
	}
	
	@GetMapping("/admin/deleteCustomerAttendance")
	public String deleteCustomerAttendance(@RequestParam(value = "u") CustomerAttendanceBO u) {
		String message = "";
		try {
			customerAttendanceRepository.delete(u);
			return "redirect:/admin/attendance";
		} catch (Exception e) {
			message = "ERROR-" + e.getMessage();
			return message;
		}
	}

}
