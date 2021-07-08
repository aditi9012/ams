package com.auditManagement.auditchecklist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.auditManagement.auditchecklist.Repository.AuditDetailRepo;
import com.auditManagement.auditchecklist.Repository.RequestRepo;
import com.auditManagement.auditchecklist.entity.AuditDetail;
import com.auditManagement.auditchecklist.entity.Request;
import com.auditManagement.auditchecklist.service.AuditDetailService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditDetailServiceTest {
	
	@MockBean
	private AuditDetailRepo mockRepo;
	
	@MockBean
	private RequestRepo repoMock;
	
	@Autowired
	private  AuditDetailService service1;
	
	
	@Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void testcreate() throws SQLException {
    	
    	AuditDetail r1=new AuditDetail();
		r1.setQ1("Yes");
		r1.setQ2("Yes");
		r1.setQ3("Yes");
		r1.setQ4("Yes");
        r1.setQ5("Yes");

		r1.setAuditType("SOX");
		OngoingStubbing<AuditDetail> thing= when(mockRepo.save(any(AuditDetail.class)));
		thing.thenReturn(r1);
		AuditDetail rs = service1.create(r1);
		assertTrue("SOX".equals(rs.getAuditType()));	
    	  }
	
		@Test
		public void testGetAll() throws SQLException {
	    	
	    	Request r1=new Request();
	    	r1.setManagerName("Soni");
	    	r1.setProjectName("Java");
	    	r1.setOwnerName("Mishra");
	    	Request r2=new Request();
			List <Request> request=new ArrayList<Request>();
			request.add(r1);
			request.add(r2);
	    		when(repoMock.findAll()).thenReturn(request);
	    		assertEquals(2,service1.getAll().size());	
	    	  }
    

}