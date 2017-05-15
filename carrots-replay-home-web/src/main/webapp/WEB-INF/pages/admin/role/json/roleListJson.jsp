<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:property name="page" value="${page}"></json:property>
	<json:property name="size" value="${size}"></json:property>
		<json:property name="total" value="${total}"></json:property>

		<json:property name="next" value="${next}"></json:property>
		<json:array  name="ids" items="${ids}"/>
	</json:object>


</json:object>


