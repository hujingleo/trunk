package com.ptteng.carrots.replay.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface CompanyService extends BaseDaoService {

	



   		   
		
		public Long insert(Company company)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Company> insertList(List<Company> companyList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Company company)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Company> companyList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Company getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Company> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCompanyIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCompanyIds() throws ServiceException, ServiceDaoException;
	

}

