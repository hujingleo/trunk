package impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.service.CompanyService;
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
public class CompanyServiceTest {

	private static final Log log = LogFactory.getLog(CompanyServiceTest.class);
	
	private CompanyService companyService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-replay-home-service/applicationContext-server.xml");
	        companyService = (CompanyService) context.getBean("companyService");
			//local server
			/**
			companyService = (CompanyService)  Naming.lookup("//localhost:10740/CompanyRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 companyService = (CompanyService) context.getBean("companyService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Company company  = new Company();
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.companyService.insert(company);

      company = this.companyService.getObjectById(id);

	  Company company2=this.companyService.getObjectById(id);
	    Assert.assertNotNull(company2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.companyService.update(company);		
		Assert.assertEquals(true, success);
		 Company company3=this.companyService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.companyService.delete(id);	
		Assert.assertEquals(true, success);
		Company company4=this.companyService.getObjectById(id);
		Assert.assertNull(company4);
		
		//4.batchInsert
		 List<Company> list=new ArrayList<Company>();
	  	  Company company5  = new Company();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(company5);	   
	  	  Company company6  = new Company();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(company6);
	   List<Company> insertResults= this.companyService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Company o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Company> getResults= this.companyService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Company o :insertResults){
			this.companyService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

