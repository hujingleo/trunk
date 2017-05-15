<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>	
	<json:property name="message" >
		<spring:message code="${code}"/>
	</json:property>
	<json:object name="data">
        <json:property name="companyId" value="${companyId}"></json:property>	


	</json:object>
</json:object>