package com.ptteng.carrots.replay.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.replay.home.model.Records;
import com.ptteng.carrots.replay.home.service.RecordsService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class RecordsServiceImpl extends BaseDaoServiceImpl implements RecordsService {

 

	private static final Log log = LogFactory.getLog(RecordsServiceImpl.class);



		   
		@Override
		public Long insert(Records records)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + records);

		if (records == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		records.setCreateAt(currentTimeMillis);
		records.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(records);
		} catch (DaoException e) {
			log.error(" insert wrong : " + records);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Records> insertList(List<Records> recordsList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (recordsList == null ? "null" : recordsList.size()));
      
		List<Records> resultList = null;

		if (CollectionUtils.isEmpty(recordsList)) {
			return new ArrayList<Records>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Records records : recordsList) {
			records.setCreateAt(currentTimeMillis);
			records.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Records>) dao.batchSave(recordsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + recordsList);
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
			result = dao.delete(Records.class, id);
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
		public boolean update(Records records)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (records == null ? "null" : records.getId()));

		boolean result = false;

		if (records == null) {
			return true;
		}

		records.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(records);
		} catch (DaoException e) {
			log.error(" update wrong : " + records);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + records);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Records> recordsList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (recordsList == null ? "null" : recordsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(recordsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Records records : recordsList) {
			records.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(recordsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + recordsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + recordsList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Records getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Records records = null;

		if (id == null) {
			return records;
		}

		try {
			records = (Records) dao.get(Records.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return records;		
		}	
		  
    	   
		@Override
		public List<Records> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Records> records = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Records>();
		}

		try {
			records = (List<Records>) dao.getList(Records.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (records == null ? "null" : records.size()));
    
		return records;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getRecordsIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getRecordsIdsAll",new Object[] {},start, limit, false);
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
	public Integer countRecordsIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRecordsIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRecordsIds " ) ;
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

