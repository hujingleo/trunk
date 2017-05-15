<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
  <json:property name="code" value="${code}"></json:property>
  <json:property name="message">
    <spring:message code="${code}" />
  </json:property>
  <json:object name="data">
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:array name="roleList">
      <c:forEach items="${roleList}" var="role">


        <json:object>


          <json:property name="id" value="${role.id}"></json:property>





          <json:property name="name" value="${role.name}"></json:property>





          <json:property name="status" value="${role.status}"></json:property>





          <json:property name="createBy" value="${role.createBy}"></json:property>





          <json:property name="updateBy" value="${role.updateBy}"></json:property>





          <json:property name="updateAt" value="${role.updateAt}"></json:property>





          <json:property name="createAt" value="${role.createAt}"></json:property>
          
             <json:object name="permissionsSet">
            <c:forEach items="${role.permissionsSet}" var="entry" >
            
             <json:array name="${entry.key}" items="${entry.value}" ></json:array>
                  
             
            </c:forEach>
                   
            
        </json:object>






        </json:object>
      </c:forEach>
    </json:array>
  </json:object>


</json:object>


