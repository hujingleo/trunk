<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="records" id="current_nav">
	<div id="recordsDetailApp" ng-app="recordsDetailApp">
		<div ng-controller="recordsDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="recordsForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="recordsId" ng-model="records.id" ng-bind="records.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="managerID" class="col-sm-2 control-label">管理员ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="managerID" ng-model="records.managerID" ng-bind="records.managerID" placeholder="请输入管理员ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="moduleID" class="col-sm-2 control-label">模块ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="moduleID" ng-model="records.moduleID" ng-bind="records.moduleID" placeholder="请输入模块ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roleID" class="col-sm-2 control-label">角色ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roleID" ng-model="records.roleID" ng-bind="records.roleID" placeholder="请输入角色ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="operate" class="col-sm-2 control-label">操作类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="operate" ng-model="records.operate" ng-bind="records.operate" placeholder="请输入操作类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="operateAt" class="col-sm-2 control-label">更新时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="operateAt" ng-model="records.operateAt" ng-bind="records.operateAt" placeholder="请输入更新时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateRecords(records)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/records">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/admin-service/records/recordsDetail.js"></script>
