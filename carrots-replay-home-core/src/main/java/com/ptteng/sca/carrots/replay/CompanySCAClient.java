/**
 * 
 */
package com.ptteng.sca.carrots.replay;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.service.CompanyService;


import java.util.List;
import java.util.Map;

public class CompanySCAClient implements CompanyService {

    private CompanyService companyService;

	public CompanyService getCompanyService() {
		return companyService;
	}
	
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService =companyService;
	}
	
	
			   
		@Override
		public Long insert(Company company)throws ServiceException, ServiceDaoException{
		
		return companyService.insert(company);
		          
		
		}	
		  
    	   
		@Override
		public List<Company> insertList(List<Company> companyList)throws ServiceException, ServiceDaoException{
		
		return companyService.insertList(companyList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return companyService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Company company)throws ServiceException, ServiceDaoException{
		
		return companyService.update(company);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Company> companyList)throws ServiceException, ServiceDaoException{
		
		return companyService.updateList(companyList);
		          
		
		}	
		  
    	   
		@Override
		public Company getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return companyService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Company> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return companyService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getCompanyIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyService.getCompanyIds(start, limit);
	}

	@Override
	public Integer countCompanyIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyService.countCompanyIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   companyService.deleteList(clz, ids);
		
	}
	
/*	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.companyService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}*/


 
}

