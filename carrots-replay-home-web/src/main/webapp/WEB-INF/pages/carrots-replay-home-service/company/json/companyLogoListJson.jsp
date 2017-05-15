<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<c:forEach items="${companyList}" var="company">
			<json:object>
                    <json:property name="logo" value="${company.logo}"></json:property>
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


