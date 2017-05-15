<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="company" id="current_nav">
	<div id="companyDetailApp" ng-app="companyDetailApp">
		<div ng-controller="companyDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="companyForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="companyId" ng-model="company.id" ng-bind="company.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">公司名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="company.name" ng-bind="company.name" placeholder="请输入公司名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="province" class="col-sm-2 control-label">省编码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="province" ng-model="company.province" ng-bind="company.province" placeholder="请输入省编码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="city" class="col-sm-2 control-label">市编码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="city" ng-model="company.city" ng-bind="company.city" placeholder="请输入市编码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="county" class="col-sm-2 control-label">县编码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="county" ng-model="company.county" ng-bind="company.county" placeholder="请输入县编码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="finacing" class="col-sm-2 control-label">融资规模</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="finacing" ng-model="company.finacing" ng-bind="company.finacing" placeholder="请输入融资规模" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="approved" class="col-sm-2 control-label">认证状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="approved" ng-model="company.approved" ng-bind="company.approved" placeholder="请输入认证状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="freezed" class="col-sm-2 control-label">冻结状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="freezed" ng-model="company.freezed" ng-bind="company.freezed" placeholder="请输入冻结状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="logo" class="col-sm-2 control-label">公司logo</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="logo" ng-model="company.logo" ng-bind="company.logo" placeholder="请输入公司logo" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="slogan" class="col-sm-2 control-label">公司标语</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="slogan" ng-model="company.slogan" ng-bind="company.slogan" placeholder="请输入公司标语" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="totalNum" class="col-sm-2 control-label">公司人数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="totalNum" ng-model="company.totalNum" ng-bind="company.totalNum" placeholder="请输入公司人数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="summary" class="col-sm-2 control-label">公司介绍</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="summary" ng-model="company.summary" ng-bind="company.summary" placeholder="请输入公司介绍" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="industry" class="col-sm-2 control-label">公司行业</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="industry" ng-model="company.industry" ng-bind="company.industry" placeholder="请输入公司行业" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">公司电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="company.phone" ng-bind="company.phone" placeholder="请输入公司电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="address" class="col-sm-2 control-label">地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="address" ng-model="company.address" ng-bind="company.address" placeholder="请输入地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="map" class="col-sm-2 control-label">公司地图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="map" ng-model="company.map" ng-bind="company.map" placeholder="请输入公司地图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">公司冻结/解冻状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="company.status" ng-bind="company.status" placeholder="请输入公司冻结/解冻状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="mail" class="col-sm-2 control-label">公司邮箱</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="mail" ng-model="company.mail" ng-bind="company.mail" placeholder="请输入公司邮箱" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="professionCount" class="col-sm-2 control-label">在招职位数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="professionCount" ng-model="company.professionCount" ng-bind="company.professionCount" placeholder="请输入在招职位数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productName" class="col-sm-2 control-label">产品名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productName" ng-model="company.productName" ng-bind="company.productName" placeholder="请输入产品名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productLogo" class="col-sm-2 control-label">产品logo</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productLogo" ng-model="company.productLogo" ng-bind="company.productLogo" placeholder="请输入产品logo" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productSolgan" class="col-sm-2 control-label">产品标语</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productSolgan" ng-model="company.productSolgan" ng-bind="company.productSolgan" placeholder="请输入产品标语" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productSummary" class="col-sm-2 control-label">产品简介</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productSummary" ng-model="company.productSummary" ng-bind="company.productSummary" placeholder="请输入产品简介" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="approvedAt" class="col-sm-2 control-label">认证时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="approvedAt" ng-model="company.approvedAt" ng-bind="company.approvedAt" placeholder="请输入认证时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="releaseAt" class="col-sm-2 control-label">最新职位上架时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="releaseAt" ng-model="company.releaseAt" ng-bind="company.releaseAt" placeholder="请输入最新职位上架时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="company.createBy" ng-bind="company.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="company.updateBy" ng-bind="company.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateCompany(company)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/company">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/carrots-replay-home-service/company/companyDetail.js"></script>
