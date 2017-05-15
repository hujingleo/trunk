<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:object name="data">
        <json:property name="id" value="${company.id}"></json:property>
        <json:property name="name" value="${company.name}"></json:property>
        <json:property name="province" value="${company.province}"></json:property>
        <json:property name="city" value="${company.city}"></json:property>
        <json:property name="county" value="${company.county}"></json:property>


        <json:property name="finacing" value="${company.finacing}"></json:property>


        <json:property name="approved" value="${company.approved}"></json:property>


        <json:property name="freezed" value="${company.freezed}"></json:property>


        <json:property name="logo" value="${company.logo}"></json:property>


        <json:property name="slogan" value="${company.slogan}"></json:property>


        <json:property name="totalNum" value="${company.totalNum}"></json:property>


        <json:property name="summary" value="${company.summary}"></json:property>


        <json:property name="industry" value="${company.industry}"></json:property>


        <json:property name="phone" value="${company.phone}"></json:property>


        <json:property name="address" value="${company.address}"></json:property>


        <json:property name="map" value="${company.map}"></json:property>


        <json:property name="mail" value="${company.mail}"></json:property>


        <json:property name="professionCount" value="${company.professionCount}"></json:property>


        <json:property name="productName" value="${company.productName}"></json:property>


        <json:property name="productLogo" value="${company.productLogo}"></json:property>


        <json:property name="productSolgan" value="${company.productSolgan}"></json:property>


        <json:property name="productSummary" value="${company.productSummary}"></json:property>


        <json:property name="approvedAt" value="${company.approvedAt}"></json:property>


<%--        <json:property name="releaseAt" value="${company.releaseAt}"></json:property>


        <json:property name="createBy" value="${company.createBy}"></json:property>


        <json:property name="updateBy" value="${company.updateBy}"></json:property>


        <json:property name="createAt" value="${company.createAt}"></json:property>


        <json:property name="updateAt" value="${company.updateAt}"></json:property>--%>

        <json:array name="companyTagList">
            <c:forEach items="${companyTagList}" var="companyTag">
                <json:object>
                    <json:property name="tag" value="${companyTag.tag}"></json:property>
                </json:object>
            </c:forEach>
        </json:array>
    </json:object>

</json:object>


