<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="article" id="current_nav">
<div id="informationApp" ng-app="informationApp">
	<div ng-controller="informationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Information管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addInformation(article)">新增</span>
		    </span>
	
			<paging url="/web/a/article">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id</td>
			        				                    <td>1:banner 2:营养健康 3:行业新闻 4:公司动态 5:公司简介 6:管理团队 7:办公环境 8:联系我们</td>
			        				                    <td>封面(在“管理团队”里为个人照片）</td>
			        				                    <td>标题（在“管理团队”里为姓名；”联系我们“为电话）</td>
			        				                    <td>顺序（正整数，控制BANNER显示的顺序，数字小的在前，选填）</td>
			        				                    <td>作者（在“管理团队”里为职业；”联系我们”：邮箱）</td>
			        				                    <td>来源（在“联系我们”里为地址）</td>
			        				                    <td>内容</td>
			        				                    <td>摘要（在“管理团队”里为描述）</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>发布时间</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>是否发布及删除（-1:未发布 0:已删除 Long:已发布,最新的修改时间，包括发布和更新）</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="article in data">
									                    <td ng-bind="article.id" ></td>
			        				                    <td ng-bind="article.type" ></td>
			        				                    <td ng-bind="article.img" ></td>
			        				                    <td ng-bind="article.title" ></td>
			        				                    <td ng-bind="article.order" ></td>
			        				                    <td ng-bind="article.author" ></td>
			        				                    <td ng-bind="article.source" ></td>
			        				                    <td ng-bind="article.content" ></td>
			        				                    <td ng-bind="article.summary" ></td>
			        				                    <td ng-bind="article.createBy" ></td>
			        				                    <td ng-bind="article.updateBy" ></td>
			        				                    <td ng-bind="article.publishat" ></td>
			        				                    <td ng-bind="article.updateAt" ></td>
			        				                    <td ng-bind="article.createAt" ></td>
			        				                    <td ng-bind="article.status" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateInformation(article.id)" />
							<input type="button" value="删除" ng-click="deleteInformation(article.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/common-blackfield-service/article/articleList.js"></script>
