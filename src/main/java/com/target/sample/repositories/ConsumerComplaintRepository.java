package com.target.sample.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.target.sample.models.ConsumerComplaint;

public interface ConsumerComplaintRepository extends ElasticsearchRepository<ConsumerComplaint, String> {

	Page<ConsumerComplaint> findByCategory(String category, Pageable pageable);
}
