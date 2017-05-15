/**
 * 
 */
package com.ptteng.sca.carrots.replay;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.service.CompanyTagService;


import java.util.List;
import java.util.Map;

public class CompanyTagSCAClient implements CompanyTagService {

    private CompanyTagService companyTagService;

	public CompanyTagService getCompanyTagService() {
		return companyTagService;
	}
	
	
	public void setCompanyTagService(CompanyTagService companyTagService) {
		this.companyTagService =companyTagService;
	}
	
	
			   
		@Override
		public Long insert(CompanyTag companyTag)throws ServiceException, ServiceDaoException{
		
		return companyTagService.insert(companyTag);
		          
		
		}	
		  
    	   
		@Override
		public List<CompanyTag> insertList(List<CompanyTag> companyTagList)throws ServiceException, ServiceDaoException{
		
		return companyTagService.insertList(companyTagList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return companyTagService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CompanyTag companyTag)throws ServiceException, ServiceDaoException{
		
		return companyTagService.update(companyTag);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CompanyTag> companyTagList)throws ServiceException, ServiceDaoException{
		
		return companyTagService.updateList(companyTagList);
		          
		
		}	
		  
    	   
		@Override
		public CompanyTag getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return companyTagService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CompanyTag> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return companyTagService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getCompanyTagIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyTagService.getCompanyTagIds(start, limit);
	}

	@Override
	public Integer countCompanyTagIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyTagService.countCompanyTagIds();
	}

	@Override
	public List<Long> getCompanyTagIdsByCompanyId(Long companyId, Integer start, Integer limit) throws ServiceException, ServiceDaoException {
		return companyTagService.getCompanyTagIds(start,limit);
	}


	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyTagService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return companyTagService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   companyTagService.deleteList(clz, ids);
		
	}
	
/*	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.companyTagService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}*/


 
}

