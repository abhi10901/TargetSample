package com.target.sample.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.target.sample.models.ConsumerComplaint;
import com.target.sample.services.ConsumerComplaintService;

@Controller
@RequestMapping("/complaints")
public class ConsumerComplaintController {

	@Autowired
	ConsumerComplaintService ccService;
	
	@GetMapping("/")
	@ResponseBody
	public List<ConsumerComplaint> getAllComplaints() {
		List<ConsumerComplaint> list = new ArrayList<>();
		
		Iterator<ConsumerComplaint> itr = ccService.findAll().iterator();
		
		while(itr.hasNext()) {
			list.add(itr.next());
		}
		
		return list;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ConsumerComplaint getComplaintById(@PathVariable String id) {
		return ccService.findOne(id);
	}
	
	@GetMapping("/category/{category}")
	@ResponseBody
	public List<ConsumerComplaint> getComplaintByCategory(@PathVariable String category) {
		return ccService.findByCategory(category, 0, 10).getContent();
	}
	
	@PostMapping("/")
	@ResponseBody
	public ConsumerComplaint save(@RequestBody ConsumerComplaint complaint) {
		return ccService.save(complaint);
	}
}
