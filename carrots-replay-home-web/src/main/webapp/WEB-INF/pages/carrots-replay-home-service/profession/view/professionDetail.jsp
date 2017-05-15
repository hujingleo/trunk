<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="profession" id="current_nav">
	<div id="professionDetailApp" ng-app="professionDetailApp">
		<div ng-controller="professionDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="professionForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="professionId" ng-model="profession.id" ng-bind="profession.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyName" class="col-sm-2 control-label">公司名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyName" ng-model="profession.companyName" ng-bind="profession.companyName" placeholder="请输入公司名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyId" class="col-sm-2 control-label">公司id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyId" ng-model="profession.companyId" ng-bind="profession.companyId" placeholder="请输入公司id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">职位名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="profession.name" ng-bind="profession.name" placeholder="请输入职位名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="category" class="col-sm-2 control-label">职业类别</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="category" ng-model="profession.category" ng-bind="profession.category" placeholder="请输入职业类别" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="education" class="col-sm-2 control-label">学历要求</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="education" ng-model="profession.education" ng-bind="profession.education" placeholder="请输入学历要求" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="experience" class="col-sm-2 control-label">工作经验</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="experience" ng-model="profession.experience" ng-bind="profession.experience" placeholder="请输入工作经验" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="compensation" class="col-sm-2 control-label">薪资</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="compensation" ng-model="profession.compensation" ng-bind="profession.compensation" placeholder="请输入薪资" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="responsibility" class="col-sm-2 control-label">岗位职责</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="responsibility" ng-model="profession.responsibility" ng-bind="profession.responsibility" placeholder="请输入岗位职责" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="requisite" class="col-sm-2 control-label">必要条件</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="requisite" ng-model="profession.requisite" ng-bind="profession.requisite" placeholder="请输入必要条件" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="boon" class="col-sm-2 control-label">公司福利</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="boon" ng-model="profession.boon" ng-bind="profession.boon" placeholder="请输入公司福利" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">上架状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="profession.status" ng-bind="profession.status" placeholder="请输入上架状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="releaseAt" class="col-sm-2 control-label">上架时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="releaseAt" ng-model="profession.releaseAt" ng-bind="profession.releaseAt" placeholder="请输入上架时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="recommend" class="col-sm-2 control-label">推荐类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="recommend" ng-model="profession.recommend" ng-bind="profession.recommend" placeholder="请输入推荐类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tagId" class="col-sm-2 control-label">职业标签id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tagId" ng-model="profession.tagId" ng-bind="profession.tagId" placeholder="请输入职业标签id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="profession.createBy" ng-bind="profession.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="profession.updateBy" ng-bind="profession.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateProfession(profession)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/profession">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/carrots-replay-home-service/profession/professionDetail.js"></script>
