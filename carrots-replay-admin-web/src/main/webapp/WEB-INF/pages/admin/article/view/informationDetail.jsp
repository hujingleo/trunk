<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="article" id="current_nav">
	<div id="informationDetailApp" ng-app="informationDetailApp">
		<div ng-controller="informationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="informationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="informationId" ng-model="article.id" ng-bind="article.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">1:banner 2:营养健康 3:行业新闻 4:公司动态 5:公司简介 6:管理团队 7:办公环境 8:联系我们</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="article.type" ng-bind="article.type" placeholder="请输入1:banner 2:营养健康 3:行业新闻 4:公司动态 5:公司简介 6:管理团队 7:办公环境 8:联系我们" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="img" class="col-sm-2 control-label">封面(在“管理团队”里为个人照片）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="img" ng-model="article.img" ng-bind="article.img" placeholder="请输入封面(在“管理团队”里为个人照片）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="title" class="col-sm-2 control-label">标题（在“管理团队”里为姓名；”联系我们“为电话）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="title" ng-model="article.title" ng-bind="article.title" placeholder="请输入标题（在“管理团队”里为姓名；”联系我们“为电话）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="order" class="col-sm-2 control-label">顺序（正整数，控制BANNER显示的顺序，数字小的在前，选填）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="order" ng-model="article.order" ng-bind="article.order" placeholder="请输入顺序（正整数，控制BANNER显示的顺序，数字小的在前，选填）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="author" class="col-sm-2 control-label">作者（在“管理团队”里为职业；”联系我们”：邮箱）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="author" ng-model="article.author" ng-bind="article.author" placeholder="请输入作者（在“管理团队”里为职业；”联系我们”：邮箱）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="source" class="col-sm-2 control-label">来源（在“联系我们”里为地址）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="source" ng-model="article.source" ng-bind="article.source" placeholder="请输入来源（在“联系我们”里为地址）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="article.content" ng-bind="article.content" placeholder="请输入内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="summary" class="col-sm-2 control-label">摘要（在“管理团队”里为描述）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="summary" ng-model="article.summary" ng-bind="article.summary" placeholder="请输入摘要（在“管理团队”里为描述）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="article.createBy" ng-bind="article.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="article.updateBy" ng-bind="article.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publishat" class="col-sm-2 control-label">发布时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publishat" ng-model="article.publishat" ng-bind="article.publishat" placeholder="请输入发布时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">是否发布及删除（-1:未发布 0:已删除 Long:已发布,最新的修改时间，包括发布和更新）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="article.status" ng-bind="article.status" placeholder="请输入是否发布及删除（-1:未发布 0:已删除 Long:已发布,最新的修改时间，包括发布和更新）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateInformation(article)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/article">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/common-blackfield-service/article/informationDetail.js"></script>
