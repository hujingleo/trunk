package com.ptteng.carrots.replay.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ProfessionService extends BaseDaoService {

	



   		   
		
		public Long insert(Profession profession)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Profession> insertList(List<Profession> professionList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Profession profession)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Profession> professionList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Profession getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Profession> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	

	     public Integer  countProfessionIdsByCompanyId(Long companyId)throws ServiceException, ServiceDaoException;

				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getProfessionIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countProfessionIds() throws ServiceException, ServiceDaoException;

	/**
	 *
	 * @param companyId
	 * @param start
	 * @param limit
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getProfessionIdsByCompanyId(Long companyId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;

}

