package impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.service.CompanyTagService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class CompanyTagServiceTest {

	private static final Log log = LogFactory.getLog(CompanyTagServiceTest.class);
	
	private CompanyTagService companyTagService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-replay-home-service/applicationContext-server.xml");
	        companyTagService = (CompanyTagService) context.getBean("companyTagService");
			//local server
			/**
			companyTagService = (CompanyTagService)  Naming.lookup("//localhost:10742/CompanyTagRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 companyTagService = (CompanyTagService) context.getBean("companyTagService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  CompanyTag companyTag  = new CompanyTag();
	   					 
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.companyTagService.insert(companyTag);

      companyTag = this.companyTagService.getObjectById(id);

	  CompanyTag companyTag2=this.companyTagService.getObjectById(id);
	    Assert.assertNotNull(companyTag2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.companyTagService.update(companyTag);		
		Assert.assertEquals(true, success);
		 CompanyTag companyTag3=this.companyTagService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.companyTagService.delete(id);	
		Assert.assertEquals(true, success);
		CompanyTag companyTag4=this.companyTagService.getObjectById(id);
		Assert.assertNull(companyTag4);
		
		//4.batchInsert
		 List<CompanyTag> list=new ArrayList<CompanyTag>();
	  	  CompanyTag companyTag5  = new CompanyTag();	   
	   					 
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(companyTag5);	   
	  	  CompanyTag companyTag6  = new CompanyTag();	   
	   					 
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(companyTag6);
	   List<CompanyTag> insertResults= this.companyTagService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(CompanyTag o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<CompanyTag> getResults= this.companyTagService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(CompanyTag o :insertResults){
			this.companyTagService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

