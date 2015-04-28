<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String contextPath = pageContext.getServletContext().getContextPath();
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>窝牛租房</title>

<script type="text/javascript" src="<%=contextPath%>/commonJS/jquery/jquery-1.8.3.js"></script>
<script src="<%=contextPath%>/bootstrap/js/bootstrap.js"></script>
<link href="<%=contextPath%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/common.css" rel="stylesheet">
<link href="<%=contextPath%>/mvcjs/personal/personal.css" rel="stylesheet">
<script src="<%=contextPath%>/mvcjs/personal/personal.js"></script>
</head>
<body>
    <c:choose>
    <c:when test="${fn:length(resultList)>0}">
	    <c:forEach items="${resultList}" var="item">
	        <div class="container-fluid" style="background-color: #FFF2DE;">
	            <div class="row">
	                <div class="house-detail font-small">
	                    <div class="house-address">
	                        <strong>${item.activityName}</strong>
	                    </div>
	                    <div class="house-info" onclick="location='${item.activityUrl}'">
	                        <div class="row">
	                            <div class="col-xs-8 font-gray">
	                                <strong>
	                                    <c:choose>
	                                        <c:when test="${item.activityStatus==1}">活动进行中</c:when>
	                                        <c:otherwise>活动已结束</c:otherwise>
	                                    </c:choose>
	                                </strong>
	                            </div>
	                            <div class="col-xs-4 price font-big font-yellow">
	                                <strong>
										<%--“寓见家”预订活动--%>
	                                    <c:if test="${item.rewardType=='2'}">
											已预约
										</c:if>
										<c:if test="${item.rewardType!='2'}">
											<c:if test="${item.isUse==1}">已用</c:if>
											<c:if test="${item.isUse!=1}">未用</c:if>
										</c:if>
	                                </strong>
	                            </div>
	                        </div>
	                        <div class="row">
	                            <div class="col-xs-8 font-gray">
	                            </div>
	                            <div class="col-xs-4 unit font-yellow">
	                                <c:choose>
                                        <c:when test="${item.rewardType=='1'}">
                                            <c:if test="${item.userReward > 0}">
                                                 <strong>${item.userReward}元租房券</strong>
                                            </c:if>
                                            <c:if test="${item.userReward <= 0}">
                                                <strong>${item.reward}元租房券</strong>
                                            </c:if>
                                        </c:when>
										<c:when test="${item.rewardType=='2'}">
											<c:if test="${item.userReward > 0}">
												<strong>已付${item.userReward}元订金</strong>
											</c:if>
											<c:if test="${item.userReward <= 0}">
												<strong>已付${item.reward}元订金</strong>
											</c:if>
										</c:when>
	                                </c:choose>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <hr />
	    </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="house-detail font-small">
                <div class="house-address">
                    <strong>没有活动参与记录</strong>
                </div>
            </div>
        </div>
    </c:otherwise>
    </c:choose>
    <div class="blank">
    </div>
</body>
</html>
