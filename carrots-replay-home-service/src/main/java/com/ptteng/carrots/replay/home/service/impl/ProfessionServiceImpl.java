package com.ptteng.carrots.replay.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.replay.home.model.Profession;
import com.ptteng.carrots.replay.home.service.ProfessionService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ProfessionServiceImpl extends BaseDaoServiceImpl implements ProfessionService {

 

	private static final Log log = LogFactory.getLog(ProfessionServiceImpl.class);



		   
		@Override
		public Long insert(Profession profession)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + profession);

		if (profession == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		profession.setCreateAt(currentTimeMillis);
		profession.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(profession);
		} catch (DaoException e) {
			log.error(" insert wrong : " + profession);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Profession> insertList(List<Profession> professionList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (professionList == null ? "null" : professionList.size()));
      
		List<Profession> resultList = null;

		if (CollectionUtils.isEmpty(professionList)) {
			return new ArrayList<Profession>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Profession profession : professionList) {
			profession.setCreateAt(currentTimeMillis);
			profession.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Profession>) dao.batchSave(professionList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + professionList);
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
			result = dao.delete(Profession.class, id);
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
		public boolean update(Profession profession)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (profession == null ? "null" : profession.getId()));

		boolean result = false;

		if (profession == null) {
			return true;
		}

		profession.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(profession);
		} catch (DaoException e) {
			log.error(" update wrong : " + profession);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + profession);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Profession> professionList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (professionList == null ? "null" : professionList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(professionList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Profession profession : professionList) {
			profession.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(professionList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + professionList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + professionList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Profession getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Profession profession = null;

		if (id == null) {
			return profession;
		}

		try {
			profession = (Profession) dao.get(Profession.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return profession;		
		}	
		  
    	   
		@Override
		public List<Profession> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Profession> profession = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Profession>();
		}

		try {
			profession = (List<Profession>) dao.getList(Profession.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (profession == null ? "null" : profession.size()));
    
		return profession;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getProfessionIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getProfessionIdsAll",new Object[] {},start, limit, false);
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
	public Integer countProfessionIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getProfessionIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getProfessionIds " ) ;
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
	public List<Long>  getProfessionIdsByCompanyId(Long companyId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{

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
			idList = dao.getIdList("getProfessionIdsByCompanyId", new Object[] { companyId},start,limit, false);


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
	@Override
	public Integer  countProfessionIdsByCompanyId(Long companyId)throws ServiceException, ServiceDaoException{

		if(log.isInfoEnabled()){
			log.info(" count ids by companyId  : " + companyId );
		}
		Integer count=null;



		try {

			count = dao.count("getProfessionIdsByCompanyId", new Object[] { companyId});


		} catch (DaoException e) {
			log.error(" count ids  wrong by companyId)  : " + companyId );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if(log.isInfoEnabled()){
			log.info(" count  success : " + count);
		}
		return count;
	}

}

