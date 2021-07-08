package com.auditManagement.Audit.ServiceTest;




import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import com.auditManagement.Audit.Entity.Request;
import com.auditManagement.Audit.Repository.RequestRepository;
import com.auditManagement.Audit.Service.RequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestServiceTest {
	
	@MockBean
	private RequestRepository mockRepo;
	
	@Autowired
	private RequestService service1;
	
	
	@Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void testcreate() throws SQLException {
    	
    	Request r1=new Request();
		r1.setProjectName("Java");
		r1.setManagerName("Soni");
		r1.setOwnerName("Mishra");
		
		OngoingStubbing<Request> thing= when(mockRepo.save(any(Request.class)));
		thing.thenReturn(r1);
		Request rs = service1.create(r1);
		assertTrue("Java".equals(rs.getProjectName()));	
    	  }
    

}
