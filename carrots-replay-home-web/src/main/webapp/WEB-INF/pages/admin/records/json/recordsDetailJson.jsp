<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${records.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="managerID" value="${records.managerID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="moduleID" value="${records.moduleID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="roleID" value="${records.roleID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="operate" value="${records.operate}"></json:property>
           
           
	   
                    			
               
                    <json:property name="operateAt" value="${records.operateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${records.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${records.updateAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


