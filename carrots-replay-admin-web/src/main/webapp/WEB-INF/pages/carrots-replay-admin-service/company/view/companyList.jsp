<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="company" id="current_nav">
<div id="companyApp" ng-app="companyApp">
	<div ng-controller="companyController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Company管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCompany(company)">新增</span>
		    </span>
	
			<paging url="/web/a/company">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>公司id,自增主键</td>
			        				                    <td>公司名称</td>
			        				                    <td>省编码</td>
			        				                    <td>市编码</td>
			        				                    <td>县编码</td>
			        				                    <td>融资规模</td>
			        				                    <td>认证状态</td>
			        				                    <td>冻结状态</td>
			        				                    <td>公司logo</td>
			        				                    <td>公司标语</td>
			        				                    <td>公司人数</td>
			        				                    <td>公司介绍</td>
			        				                    <td>公司行业</td>
			        				                    <td>公司电话</td>
			        				                    <td>地址</td>
			        				                    <td>公司地图</td>
			        				                    <td>公司冻结/解冻状态</td>
			        				                    <td>公司邮箱</td>
			        				                    <td>在招职位数</td>
			        				                    <td>产品名称</td>
			        				                    <td>产品logo</td>
			        				                    <td>产品标语</td>
			        				                    <td>产品简介</td>
			        				                    <td>认证时间</td>
			        				                    <td>最新职位上架时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="company in data">				
									                    <td ng-bind="company.id" ></td>
			        				                    <td ng-bind="company.name" ></td>
			        				                    <td ng-bind="company.province" ></td>
			        				                    <td ng-bind="company.city" ></td>
			        				                    <td ng-bind="company.county" ></td>
			        				                    <td ng-bind="company.finacing" ></td>
			        				                    <td ng-bind="company.approved" ></td>
			        				                    <td ng-bind="company.freezed" ></td>
			        				                    <td ng-bind="company.logo" ></td>
			        				                    <td ng-bind="company.slogan" ></td>
			        				                    <td ng-bind="company.totalNum" ></td>
			        				                    <td ng-bind="company.summary" ></td>
			        				                    <td ng-bind="company.industry" ></td>
			        				                    <td ng-bind="company.phone" ></td>
			        				                    <td ng-bind="company.address" ></td>
			        				                    <td ng-bind="company.map" ></td>
			        				                    <td ng-bind="company.status" ></td>
			        				                    <td ng-bind="company.mail" ></td>
			        				                    <td ng-bind="company.professionCount" ></td>
			        				                    <td ng-bind="company.productName" ></td>
			        				                    <td ng-bind="company.productLogo" ></td>
			        				                    <td ng-bind="company.productSolgan" ></td>
			        				                    <td ng-bind="company.productSummary" ></td>
			        				                    <td ng-bind="company.approvedAt" ></td>
			        				                    <td ng-bind="company.releaseAt" ></td>
			        				                    <td ng-bind="company.createBy" ></td>
			        				                    <td ng-bind="company.updateBy" ></td>
			        				                    <td ng-bind="company.createAt" ></td>
			        				                    <td ng-bind="company.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCompany(company.id)" /> 
							<input type="button" value="删除" ng-click="deleteCompany(company.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-replay-home-service/company/companyList.js"></script>
