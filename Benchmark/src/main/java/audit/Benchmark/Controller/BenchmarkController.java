package audit.Benchmark.Controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import audit.Benchmark.Service.BenchmarkService;
import audit.Benchmark.entity.AuditBenchmark;

@RestController

public class BenchmarkController {
	
	@Autowired
	private BenchmarkService benchService;
	
	private Logger logger = LoggerFactory.getLogger(BenchmarkController.class);
	
	@GetMapping("/AuditBenchmark")
	public HashMap<String,Integer> getBenchmark(){
		List<AuditBenchmark> list=benchService.getAuditType();
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
		for (int i=0; i<list.size(); i++) {
	      map.put(list.get(i).getAuditType(), list.get(i).getBenchmarkNoAnswers()); 
	    }
		logger.info("benchmarkdetails",map);
		return map;
	}

}
