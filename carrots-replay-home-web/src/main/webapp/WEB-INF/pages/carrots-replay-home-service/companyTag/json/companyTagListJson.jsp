<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<c:forEach items="${companyTagList}" var="companyTag">
			<json:object>
					
               
                    <json:property name="id" value="${companyTag.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyId" value="${companyTag.companyId}"></json:property>
           
           
	   
        			
               
                    <json:property name="tag" value="${companyTag.tag}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${companyTag.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${companyTag.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${companyTag.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${companyTag.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


