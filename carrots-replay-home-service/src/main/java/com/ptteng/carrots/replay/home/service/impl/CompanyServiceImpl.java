package com.ptteng.carrots.replay.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.replay.home.model.Company;
import com.ptteng.carrots.replay.home.service.CompanyService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class CompanyServiceImpl extends BaseDaoServiceImpl implements CompanyService {

 

	private static final Log log = LogFactory.getLog(CompanyServiceImpl.class);



		   
		@Override
		public Long insert(Company company)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + company);

		if (company == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		company.setCreateAt(currentTimeMillis);
		company.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(company);
		} catch (DaoException e) {
			log.error(" insert wrong : " + company);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Company> insertList(List<Company> companyList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (companyList == null ? "null" : companyList.size()));
      
		List<Company> resultList = null;

		if (CollectionUtils.isEmpty(companyList)) {
			return new ArrayList<Company>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Company company : companyList) {
			company.setCreateAt(currentTimeMillis);
			company.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Company>) dao.batchSave(companyList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + companyList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Company.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Company company)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (company == null ? "null" : company.getId()));

		boolean result = false;

		if (company == null) {
			return true;
		}

		company.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(company);
		} catch (DaoException e) {
			log.error(" update wrong : " + company);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + company);
       }
		return result;	
		}


	@Override
		public boolean updateList(List<Company> companyList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (companyList == null ? "null" : companyList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(companyList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Company company : companyList) {
			company.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(companyList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + companyList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + companyList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Company getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Company company = null;

		if (id == null) {
			return company;
		}

		try {
			company = (Company) dao.get(Company.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return company;		
		}	
		  
    	   
		@Override
		public List<Company> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Company> company = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Company>();
		}

		try {
			company = (List<Company>) dao.getList(Company.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (company == null ? "null" : company.size()));
    
		return company;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getCompanyIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getCompanyIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countCompanyIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCompanyIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCompanyIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

