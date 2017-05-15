package impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.carrots.replay.home.service.ProfessionService;
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
public class ProfessionServiceTest {

	private static final Log log = LogFactory.getLog(ProfessionServiceTest.class);
	
	private ProfessionService professionService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-replay-home-service/applicationContext-server.xml");
	        professionService = (ProfessionService) context.getBean("professionService");
			//local server
			/**
			professionService = (ProfessionService)  Naming.lookup("//localhost:10741/ProfessionRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 professionService = (ProfessionService) context.getBean("professionService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Profession profession  = new Profession();
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.professionService.insert(profession);

      profession = this.professionService.getObjectById(id);

	  Profession profession2=this.professionService.getObjectById(id);
	    Assert.assertNotNull(profession2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.professionService.update(profession);		
		Assert.assertEquals(true, success);
		 Profession profession3=this.professionService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.professionService.delete(id);	
		Assert.assertEquals(true, success);
		Profession profession4=this.professionService.getObjectById(id);
		Assert.assertNull(profession4);
		
		//4.batchInsert
		 List<Profession> list=new ArrayList<Profession>();
	  	  Profession profession5  = new Profession();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(profession5);	   
	  	  Profession profession6  = new Profession();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(profession6);
	   List<Profession> insertResults= this.professionService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Profession o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Profession> getResults= this.professionService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Profession o :insertResults){
			this.professionService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

