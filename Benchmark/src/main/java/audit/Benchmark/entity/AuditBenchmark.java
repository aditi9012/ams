package audit.Benchmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auditbenchmark")
public class AuditBenchmark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "AuditType")
	private String AuditType;

	

	@Override
	public String toString() {
		return "AuditBenchmark [id=" + id + ", AuditType=" + AuditType + ", BenchmarkNoAnswers=" + BenchmarkNoAnswers
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBenchmarkNoAnswers() {
		return BenchmarkNoAnswers;
	}

	public void setBenchmarkNoAnswers(int benchmarkNoAnswers) {
		BenchmarkNoAnswers = benchmarkNoAnswers;
	}

	public String getAuditType() {
		return AuditType;
	}

	public void setAuditType(String auditType) {
		AuditType = auditType;
	}

	@Column(name = "BenchmarkNoAnswers")
	private int BenchmarkNoAnswers;

}
