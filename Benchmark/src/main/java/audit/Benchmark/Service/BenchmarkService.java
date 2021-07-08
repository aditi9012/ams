package audit.Benchmark.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import audit.Benchmark.dao.BenchmarkDao;
import audit.Benchmark.entity.AuditBenchmark;

@Service
@Transactional
public class BenchmarkService  {
	
	@Autowired
	private BenchmarkDao benchmarkdao;
	
	public List<AuditBenchmark> getAuditType(){
		return benchmarkdao.findAll();
	}

}
