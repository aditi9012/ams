package audit.Benchmark.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import audit.Benchmark.Service.BenchmarkService;
import audit.Benchmark.dao.BenchmarkDao;
import audit.Benchmark.entity.AuditBenchmark;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditBenchmarkServiceTest {
	
	@MockBean
	private BenchmarkDao repoMock;
	
	@Autowired
	private  BenchmarkService service1;
	
	@Test
	public void testGetAll() throws SQLException {
    	
    	AuditBenchmark r1=new AuditBenchmark();
    	r1.setAuditType("SOX");
    	r1.setBenchmarkNoAnswers(1);
    	AuditBenchmark r2=new AuditBenchmark();
		List <AuditBenchmark> request=new ArrayList<AuditBenchmark>();
		request.add(r1);
		request.add(r2);
    		when(repoMock.findAll()).thenReturn(request);
    		assertEquals(2,service1.getAuditType().size());	
    	  }

}
