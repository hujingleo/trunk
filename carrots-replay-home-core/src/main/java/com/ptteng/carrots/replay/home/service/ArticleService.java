package com.ptteng.carrots.replay.home.service;

import java.util.List;
import java.util.Map;

import com.ptteng.carrots.replay.home.model.Article;
import org.osoa.sca.annotations.Remotable;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface ArticleService extends BaseDaoService {

	



   		   
		
		public Long insert(Article article)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Article> insertList(List<Article> articleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Article article)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Article> articleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Article getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Article> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getArticleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countArticleIds() throws ServiceException, ServiceDaoException;


	Object getObjectByDynamicCondition(Class clz,
									   Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;
}

