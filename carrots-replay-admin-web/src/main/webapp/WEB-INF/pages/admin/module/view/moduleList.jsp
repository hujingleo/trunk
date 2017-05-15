<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<head>
	<script>
		function updatemodule(id){
			console.log("want edit "+id);
			location.href = '/web/a/updateModuleInit?id='+id;
		}

	</script>
</head>
<body>

<input type="hidden" value="module" id="current_nav">
<div id="moduleApp" ng-app="moduleApp">
	<div ng-controller="moduleController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Module管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span onclick="addModule()">新增</span>
		    </span>
	
			<paging url="/web/a/module">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td> id</td>
			        				                    <td>父模块id</td>
			        				                    <td>模块名</td>
			        				                    <td>英文名称</td>
			        				                    <td>URL</td>
			        				                    <td>模块类别</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<c:forEach items="${data}" var="module">

						<tr ng-repeat="module in data">
							<td  >${module.id}</td>
							<td ng-bind="module.parentid" >${module.parentid}</td>
							<td ng-bind="module.name" >${module.name}</td>
							<td ng-bind="module.nameEgl" >${module.nameEgl}</td>
							<td ng-bind="module.url" >${module.url}</td>
							<td ng-bind="module.type" >${module.type}</td>
							<td ng-bind="module.createBy" >${module.createBy}</td>
							<td ng-bind="module.updateBy" >${module.updateBy}</td>
							<td ng-bind="module.updateAt" >${module.updateAt}</td>
							<td ng-bind="module.createAt" >${module.createAt}</td>

							<td>
								<input type="button" value="修改" onclick="updateModule(module.id)"  />
								<input type="button" value="删除" ng-click="deleteModule(module.id)" />
							</td>
						</tr>
					</c:forEach>

				</table>		
			</paging>
	
		</div>
	</div>
</div>
</body>
<!-- Angular JS -->
<script src="/r/js-src/web/common-blackfield-service/module/moduleList.js"></script>
