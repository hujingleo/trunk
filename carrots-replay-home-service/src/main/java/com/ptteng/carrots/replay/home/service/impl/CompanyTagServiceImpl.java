package com.ptteng.carrots.replay.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.replay.home.model.CompanyTag;
import com.ptteng.carrots.replay.home.service.CompanyTagService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class CompanyTagServiceImpl extends BaseDaoServiceImpl implements CompanyTagService {

 

	private static final Log log = LogFactory.getLog(CompanyTagServiceImpl.class);



		   
		@Override
		public Long insert(CompanyTag companyTag)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + companyTag);

		if (companyTag == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		companyTag.setCreateAt(currentTimeMillis);
		companyTag.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(companyTag);
		} catch (DaoException e) {
			log.error(" insert wrong : " + companyTag);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<CompanyTag> insertList(List<CompanyTag> companyTagList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (companyTagList == null ? "null" : companyTagList.size()));
      
		List<CompanyTag> resultList = null;

		if (CollectionUtils.isEmpty(companyTagList)) {
			return new ArrayList<CompanyTag>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CompanyTag companyTag : companyTagList) {
			companyTag.setCreateAt(currentTimeMillis);
			companyTag.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CompanyTag>) dao.batchSave(companyTagList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + companyTagList);
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
			result = dao.delete(CompanyTag.class, id);
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
		public boolean update(CompanyTag companyTag)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (companyTag == null ? "null" : companyTag.getId()));

		boolean result = false;

		if (companyTag == null) {
			return true;
		}

		companyTag.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(companyTag);
		} catch (DaoException e) {
			log.error(" update wrong : " + companyTag);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + companyTag);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CompanyTag> companyTagList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (companyTagList == null ? "null" : companyTagList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(companyTagList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CompanyTag companyTag : companyTagList) {
			companyTag.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(companyTagList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + companyTagList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + companyTagList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public CompanyTag getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		CompanyTag companyTag = null;

		if (id == null) {
			return companyTag;
		}

		try {
			companyTag = (CompanyTag) dao.get(CompanyTag.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return companyTag;		
		}	
		  
    	   
		@Override
		public List<CompanyTag> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<CompanyTag> companyTag = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CompanyTag>();
		}

		try {
			companyTag = (List<CompanyTag>) dao.getList(CompanyTag.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (companyTag == null ? "null" : companyTag.size()));
    
		return companyTag;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getCompanyTagIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCompanyTagIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCompanyTagIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCompanyTagIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCompanyTagIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}
	@Override
	public List<Long>  getCompanyTagIdsByCompanyId(Long companyId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{

		if(log.isInfoEnabled()){
			log.info(" get ids by companyId,start,limit  : " + companyId+" , "+start+" , "+limit );
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getCompanyTagIdsByCompanyId", new Object[] { companyId},start,limit, false);


		} catch (DaoException e) {
			log.error(" get ids  wrong by companyId,start,limit)  : " + companyId+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if(log.isInfoEnabled()){
			log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
		}
		return idList;



	}
}

