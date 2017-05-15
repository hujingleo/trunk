<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="profession" id="current_nav">
<div id="professionApp" ng-app="professionApp">
	<div ng-controller="professionController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Profession管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProfession(profession)">新增</span>
		    </span>
	
			<paging url="/web/a/profession">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>职位id自增主键</td>
			        				                    <td>公司名称</td>
			        				                    <td>公司id</td>
			        				                    <td>职位名称</td>
			        				                    <td>职业类别</td>
			        				                    <td>学历要求</td>
			        				                    <td>工作经验</td>
			        				                    <td>薪资</td>
			        				                    <td>岗位职责</td>
			        				                    <td>必要条件</td>
			        				                    <td>公司福利</td>
			        				                    <td>上架状态</td>
			        				                    <td>上架时间</td>
			        				                    <td>推荐类型</td>
			        				                    <td>职业标签id</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="profession in data">				
									                    <td ng-bind="profession.id" ></td>
			        				                    <td ng-bind="profession.companyName" ></td>
			        				                    <td ng-bind="profession.companyId" ></td>
			        				                    <td ng-bind="profession.name" ></td>
			        				                    <td ng-bind="profession.category" ></td>
			        				                    <td ng-bind="profession.education" ></td>
			        				                    <td ng-bind="profession.experience" ></td>
			        				                    <td ng-bind="profession.compensation" ></td>
			        				                    <td ng-bind="profession.responsibility" ></td>
			        				                    <td ng-bind="profession.requisite" ></td>
			        				                    <td ng-bind="profession.boon" ></td>
			        				                    <td ng-bind="profession.status" ></td>
			        				                    <td ng-bind="profession.releaseAt" ></td>
			        				                    <td ng-bind="profession.recommend" ></td>
			        				                    <td ng-bind="profession.tagId" ></td>
			        				                    <td ng-bind="profession.createBy" ></td>
			        				                    <td ng-bind="profession.updateBy" ></td>
			        				                    <td ng-bind="profession.updateAt" ></td>
			        				                    <td ng-bind="profession.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProfession(profession.id)" /> 
							<input type="button" value="删除" ng-click="deleteProfession(profession.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-replay-home-service/profession/professionList.js"></script>
