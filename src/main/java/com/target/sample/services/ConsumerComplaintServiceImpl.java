package com.target.sample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.target.sample.models.ConsumerComplaint;
import com.target.sample.repositories.ConsumerComplaintRepository;

@Service
public class ConsumerComplaintServiceImpl implements ConsumerComplaintService {
	
	@Autowired
	ConsumerComplaintRepository ccRepository;

	@Override
	public ConsumerComplaint save(ConsumerComplaint complaint) {
		return ccRepository.save(complaint);
	}

	@Override
	public ConsumerComplaint findOne(String id) {
		return ccRepository.findOne(id);
	}

	@Override
	public Iterable<ConsumerComplaint> findAll() {
		return ccRepository.findAll();
	}

	@Override
	public Page<ConsumerComplaint> findByCategory(String category, int offset, int max) {
		return ccRepository.findByCategory(category, new PageRequest(offset, max));
	}

}
