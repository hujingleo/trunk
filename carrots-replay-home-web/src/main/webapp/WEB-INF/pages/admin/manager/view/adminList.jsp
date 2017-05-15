<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="manager" id="current_nav">
<div id="adminApp" ng-app="adminApp">
	<div ng-controller="adminController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Admin管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAdmin(manager)">新增</span>
		    </span>
	
			<paging url="/web/a/manager">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长admin id</td>
			        				                    <td>登录名</td>
			        				                    <td>密码</td>
			        				                    <td>姓名</td>
			        				                    <td>角色ID</td>
			        				                    <td>角色名</td>
			        				                    <td>用户状态（1：启用 0：停用）</td>
			        				                    <td>创建人姓名</td>
			        				                    <td>更新人姓名</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="manager in data">
									                    <td ng-bind="manager.id" ></td>
			        				                    <td ng-bind="manager.username" ></td>
			        				                    <td ng-bind="manager.password" ></td>
			        				                    <td ng-bind="manager.name" ></td>
			        				                    <td ng-bind="manager.roleId" ></td>
			        				                    <td ng-bind="manager.roleName" ></td>
			        				                    <td ng-bind="manager.status" ></td>
			        				                    <td ng-bind="manager.createBy" ></td>
			        				                    <td ng-bind="manager.updateBy" ></td>
			        				                    <td ng-bind="manager.updateAt" ></td>
			        				                    <td ng-bind="manager.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAdmin(manager.id)" />
							<input type="button" value="删除" ng-click="deleteAdmin(manager.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/common-blackfield-service/manager/managerList.js"></script>
