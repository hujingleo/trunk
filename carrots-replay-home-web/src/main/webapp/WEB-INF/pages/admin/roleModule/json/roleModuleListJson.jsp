<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:array name="data">
		<c:forEach items="${roleModuleList}" var="roleModule">
			<json:object>
					
               
                    <json:property name="id" value="${roleModule.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="rid" value="${roleModule.rid}"></json:property>
           
           
	   
        			
               
                    <json:property name="mid" value="${roleModule.mid}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${roleModule.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${roleModule.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${roleModule.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${roleModule.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


