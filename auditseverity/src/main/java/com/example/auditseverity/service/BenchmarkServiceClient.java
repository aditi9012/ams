package com.example.auditseverity.service;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@Component
@FeignClient(name="benchmarkService", url = "http://localhost:8999")
public interface BenchmarkServiceClient {
	
	@GetMapping("/AuditBenchmark")
    HashMap<String,Integer> findAll();

}
