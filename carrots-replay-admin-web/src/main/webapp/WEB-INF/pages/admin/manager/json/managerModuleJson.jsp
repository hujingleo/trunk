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

  <json:property name="total" value="${total}"></json:property>

  <json:array name="modules">
    <c:forEach items="${modules}" var="module">
      <json:object>


        <json:property name="id" value="${module.id}"></json:property>





        <json:property name="parentid" value="${module.parentid}"></json:property>





        <json:property name="name" value="${module.name}"></json:property>





        <json:property name="menuId" value="${module.menuId}"></json:property>





        <json:property name="url" value="${module.url}"></json:property>





        <json:property name="type" value="${module.type}"></json:property>





        <json:property name="createBy" value="${module.createBy}"></json:property>





        <json:property name="updateBy" value="${module.updateBy}"></json:property>





        <json:property name="updateAt" value="${module.updateAt}"></json:property>





        <json:property name="createAt" value="${module.createAt}"></json:property>



      </json:object>
    </c:forEach>
  </json:array>
  </json:object>


</json:object>


