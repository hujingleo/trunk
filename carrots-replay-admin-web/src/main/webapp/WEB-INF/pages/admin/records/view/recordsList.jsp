<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="records" id="current_nav">
<div id="recordsApp" ng-app="recordsApp">
	<div ng-controller="recordsController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Records管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRecords(records)">新增</span>
		    </span>
	
			<paging url="/web/a/records">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>管理员ID</td>
			        				                    <td>模块ID</td>
			        				                    <td>角色ID</td>
			        				                    <td>操作类型</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="records in data">				
									                    <td ng-bind="records.id" ></td>
			        				                    <td ng-bind="records.managerID" ></td>
			        				                    <td ng-bind="records.moduleID" ></td>
			        				                    <td ng-bind="records.roleID" ></td>
			        				                    <td ng-bind="records.operate" ></td>
			        				                    <td ng-bind="records.operateAt" ></td>
			        				                    <td ng-bind="records.createAt" ></td>
			        				                    <td ng-bind="records.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRecords(records.id)" /> 
							<input type="button" value="删除" ng-click="deleteRecords(records.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/admin-service/records/recordsList.js"></script>
