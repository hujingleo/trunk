<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="module" id="current_nav">
	<div id="moduleDetailApp" ng-app="moduleDetailApp">
		<div ng-controller="moduleDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="moduleForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="moduleId" ng-model="module.id" ng-bind="module.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="parentid" class="col-sm-2 control-label">父模块id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="parentid" ng-model="module.parentid" ng-bind="module.parentid" placeholder="请输入父模块id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">模块名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="module.name" ng-bind="module.name" placeholder="请输入模块名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="nameEgl" class="col-sm-2 control-label">英文名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="nameEgl" ng-model="module.nameEgl" ng-bind="module.nameEgl" placeholder="请输入英文名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="url" class="col-sm-2 control-label">模块对应URL地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="url" ng-model="module.url" ng-bind="module.url" placeholder="请输入模块对应URL地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">模块类别</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="module.type" ng-bind="module.type" placeholder="请输入模块类别" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="module.createBy" ng-bind="module.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="module.updateBy" ng-bind="module.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateModule(module)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/module">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/common-blackfield-service/module/moduleDetail.js"></script>
