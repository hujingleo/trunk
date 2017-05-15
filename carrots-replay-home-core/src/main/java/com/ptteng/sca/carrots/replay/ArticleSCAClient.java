/**
 * 
 */
package com.ptteng.sca.carrots.replay;

import java.util.List;
import java.util.Map;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.replay.home.model.Article;
import com.ptteng.carrots.replay.home.service.ArticleService;

public class ArticleSCAClient implements ArticleService {

    private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}
	
	
	public void setArticleService(ArticleService articleService) {
		this.articleService =articleService;
	}
	
	
			   
		@Override
		public Long insert(Article article)throws ServiceException, ServiceDaoException{
		
		return articleService.insert(article);
		          
		
		}	
		  
    	   
		@Override
		public List<Article> insertList(List<Article> articleList)throws ServiceException, ServiceDaoException{
		
		return articleService.insertList(articleList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return articleService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Article article)throws ServiceException, ServiceDaoException{
		
		return articleService.update(article);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Article> articleList)throws ServiceException, ServiceDaoException{
		
		return articleService.updateList(articleList);
		          
		
		}	
		  
    	   
		@Override
		public Article getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return articleService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Article> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return articleService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getArticleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return articleService.getArticleIds(start, limit);
	}

	@Override
	public Integer countArticleIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return articleService.countArticleIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return articleService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return articleService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   articleService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.articleService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

