package audit.Benchmark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import audit.Benchmark.entity.AuditBenchmark;

public interface BenchmarkDao extends JpaRepository<AuditBenchmark, Integer> {
	
}
