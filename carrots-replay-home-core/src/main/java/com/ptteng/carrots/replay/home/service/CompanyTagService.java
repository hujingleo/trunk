package com.ptteng.carrots.replay.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface CompanyTagService extends BaseDaoService {

	



   		   
		
		public Long insert(CompanyTag companyTag)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CompanyTag> insertList(List<CompanyTag> companyTagList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(CompanyTag companyTag)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<CompanyTag> companyTagList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public CompanyTag getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CompanyTag> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCompanyTagIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCompanyTagIds() throws ServiceException, ServiceDaoException;

	public List<Long>  getCompanyTagIdsByCompanyId(Long companyId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
}

