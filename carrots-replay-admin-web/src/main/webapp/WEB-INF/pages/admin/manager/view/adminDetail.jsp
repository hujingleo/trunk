<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="manager" id="current_nav">
	<div id="adminDetailApp" ng-app="adminDetailApp">
		<div ng-controller="adminDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="adminForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="adminId" ng-model="manager.id" ng-bind="manager.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="username" class="col-sm-2 control-label">登录名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="username" ng-model="manager.username" ng-bind="manager.username" placeholder="请输入登录名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="password" class="col-sm-2 control-label">密码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="password" ng-model="manager.password" ng-bind="manager.password" placeholder="请输入密码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="manager.name" ng-bind="manager.name" placeholder="请输入姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roleId" class="col-sm-2 control-label">角色ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" value="${manager.roleId}" name="roleId" ng-model="manager.roleId" ng-bind="manager.roleId" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roleName" class="col-sm-2 control-label">角色名</label>
			        <div class="col-sm-6">
			          <input type="text" value="${manager.roleName}" class="form-control" name="roleName" ng-model="manager.roleName" ng-bind="manager.roleName" placeholder="请输入角色名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">用户状态（1：启用 0：停用）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="manager.status" ng-bind="manager.status" placeholder="请输入用户状态（1：启用 0：停用）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="manager.createBy" ng-bind="manager.createBy" placeholder="请输入创建人姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="manager.updateBy" ng-bind="manager.updateBy" placeholder="请输入更新人姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateAdmin(manager)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/manager">取消</a>
			        </div>
			      </div>
			     <div>
					 <select>
						 <c:forEach items="${roles}" var="role">
							 <option value="${role.id}">${role.name}</option>
						 </c:forEach>

					 </select>
				 </div>
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/common-blackfield-service/manager/adminDetail.js"></script>
