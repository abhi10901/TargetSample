package com.target.sample.services;

import org.springframework.data.domain.Page;
import com.target.sample.models.ConsumerComplaint;

public interface ConsumerComplaintService {
		ConsumerComplaint save(ConsumerComplaint complaint);
		ConsumerComplaint findOne(String id);
		Iterable<ConsumerComplaint> findAll();
		Page<ConsumerComplaint> findByCategory(String category, int offset, int max);
}
