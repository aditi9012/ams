package com.example.auditseverity.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;



import org.junit.jupiter.api.Test;

import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.auditseverity.entity.AuditDetail;
import com.example.auditseverity.entity.AuditResponse;
import com.example.auditseverity.repository.AuditDetailRepo;
import com.example.auditseverity.repository.AuditSeverityRepo;
import com.example.auditseverity.service.AuditResponseService;



//@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditSeverityServiceTest {
	
	@MockBean
	private AuditDetailRepo auditDaoMock;
	
	@Autowired
	private AuditResponseService auditResponseService;
	
	@MockBean 
	private AuditSeverityRepo responseRepo;
	
	
	
	
	@Test
	public void testgetAll() {
		AuditDetail au=new AuditDetail();
		au.setAuditType("SOX");
		au.setId(1);
		au.setQ1("yes");
		au.setQ2("no");
		au.setQ3("yes");
		au.setQ4("no");
		au.setQ5("yes");
		
		ArrayList<AuditDetail> li=new ArrayList<AuditDetail>();
		li.add(au);
	
		
		when(auditDaoMock.findAll()).thenReturn(li);
		
		assertThat(auditResponseService.getAll(), hasSize(1));
		
		assertEquals("yes", au.getQ1());
	}
	
	
	@Test
	public void testcreate() {
		
		AuditResponse res=new AuditResponse();
		res.setProjectExecutionStatus("Red");
		res.setRemedialActionDuration("1 week");
		
		OngoingStubbing<AuditResponse> thing= when(responseRepo.save(any(AuditResponse.class)));
		thing.thenReturn(res);
		AuditResponse rs = auditResponseService.create(res);
		
		assertTrue("Red".equals(rs.getProjectExecutionStatus()));	
	}

}