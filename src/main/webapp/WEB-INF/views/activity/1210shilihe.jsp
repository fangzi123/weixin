<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String contextPath = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN" style="overflow: hidden; height: 100%;"><head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>3000元租不到好公寓？我不许你这么说</title>
	<link rel="stylesheet" href="<%=contextPath %>/resources/css/activity/jquery.fullPage.css">
	<link href="<%=contextPath %>/resources/css/layer.css" rel="stylesheet">
	<link href="<%=contextPath %>/resources/css/activity/global.css" rel="stylesheet" type="text/css">
	<script src="<%=contextPath %>/commonJS/jquery/jquery-1.8.3.js"></script>
	<script src="<%=contextPath%>/commonJS/jquery/layer.min.js"></script>
	<script src="<%=contextPath %>/resources/js/activity/jquery-ui-1.10.3.min.js"></script>
	<script src="<%=contextPath %>/resources/js/activity/jquery.fullPage.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/resources/js/activity/jquery.event.drag-1.5.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/resources/js/activity/jquery.touchSlider.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/resources/js/activity/lunbotu.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/mvcjs/activity/1210shilihe.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/mvcjs/activity/weixin.js"></script>
	<style>	
		.section { text-align: center; font: 50px "Microsoft Yahei"; color: #fff;}
		img.photo{
			width: 100%;
		}

		div.house-pictures {
			position: absolute;
			bottom: 3%;
			height: 190px;
		}
	
		.house-pictures {
			width: 84%;
			margin-left: 8%;
			margin-right: 8%;
			margin-bottom: 2%;
		}
		
		img.img-house-info-1 {
			position: absolute;
			top: 0px;
		}
		
		img.img-house-info-1 {
			position: absolute;
			top: 0px;
		}
		
		img.img-house-info-1 {
			position: absolute;
			top: 0px;
		}
		
		
		/* 输入框按钮高度 */
		div.div-house-inf {
			position: absolute;
			top: 15%;
			width: 90%;
			margin-left: 5%;
			margin-right: 5%;
			font: 16px "Microsoft Yahei";
		}

		div.div-house-inf img {
		      margin-top: 20px;
		}

		.input-height-sm {
			height: 2em;
			border-radius: 8px;
			font-size: 16px;
		}
		
		.input-height-lg {
			font-size: 18px;
			border-radius: 8px;
			height: 2.5em;
		}
		
		div.row {
			margin-top: 3%;
			margin-bottom: 3%;
			font: 16px "Microsoft Yahei";
		}
			div.row:last-child {
				margin-top: 5%;
				margin-bottom: 18px;
			}
		
		.bg-yellow {
			background-color: #F39600;
			color: #FFFFFF;
		}
		
		.bg-gray {
		  background-color: gray;
		}
		
		/* 输入法出来时整体页面上移 */
		@-webkit-keyframes move-up {
			from {top: 50px;}
			to {top: -200px;}
		}
		@-webkit-keyframes move-down {
			from {top: -200px;}
			to {top: 50px;}
		}
		div.input-text {
			-webkit-animation-fill-mode: forwards;
		}
		
		/* 隐藏输入框 */
		div.input-text {
			position: absolute;
			top: -200px;
			width: 90%;
			margin-left: 5%;
			margin-right: 5%;
		}
		div.input-text input {
			width: 100%;
			font-size: 16px;
			height: 2.5em;
			border-radius: 8px;
		}
		.show {
			display: block;
		}
		.hidden {
			display: none;
		}
		
		/* 轮播图左右图标 */
		.div-prev, .div-next {
			position: absolute;
			z-index: 99999;
			width: 15px;
			height: 25px;
			top: 32%;
		}
			.div-prev {
				left: -20px;
			}
			.div-next {
				right: -20px;
			}
			.div-prev img, .div-next img {
				width: 100%;
				height: 100%;
			}
			.div-down {
				position: fixed;
				z-index: 99999;
				width: 30px;
				height: 15px;
				bottom: 6px;
				left: 45%;
			}
				img.div-down {
					-webkit-animation: shanxian 0.5s;
					-webkit-animation-iteration-count: infinite;
					-webkit-animation-direction: alternate;
				}
		/* 闪现动画 */
		@-webkit-keyframes shanxian {
			0%   { opacity: 1;}
			100% { opacity: 0;}
		}
	</style>
</head>
<body style="overflow: hidden; height: 100%;">
<form>
	<div class="section">
		<img class="photo" src="<%=contextPath %>/images/activity/1210shilihe/${gender}-box-1.jpg" />
		<div class="house-pictures">
			<div class="banner" style="width: 100%;height: 100%;">
				<div class="main_visual" style="height: 100%;">
					<div class="main_image" style="height: 100%;">
						<ul style="width: 100%; overflow: visible;height: 100%;">
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/1.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/2.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/3.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/4.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/5.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/6.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/7.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/8.jpg"></li>
							<li><img src="<%=contextPath %>/images/activity/1210shilihe/9.jpg"></li>
						</ul>
						<a href="javascript:;" id="btn_prev0" style="width: 320px; overflow: visible;"></a> 
						<a href="javascript:;" id="btn_next0" style="width: 320px; overflow: visible;"></a>
					</div>
				</div>
			</div>
			<div class="div-prev"><img src="<%=contextPath %>/images/activity/1210shilihe/prev.png"></div>
			<div class="div-next"><img src="<%=contextPath %>/images/activity/1210shilihe/next.png"></div>
			<img class="div-down" src="<%=contextPath %>/images/activity/1210shilihe/down.png">
		</div>
	</div>

	<div class="section">
		<img class="photo" src="<%=contextPath %>/images/activity/1210shilihe/${gender}-box-2.jpg" />
	</div>

	<div class="section" >
		<img class="photo" src="<%=contextPath %>/images/activity/1210shilihe/${gender}-box-3.jpg">
		<c:choose>
		    <c:when test="${ordered==false}">
		        <div class="div-house-inf">
		            <div class="row">
						<table style="width:100%"><tr><td style="padding-right: 4px;">
							<input name="orderTel" type="text" class="input-height-sm" placeholder="请输入您的手机号" style="width: 90%;padding-right:5%;padding-left:5%;">
						</tr></td></table>
		            </div>
		            <div class="row" style="text-align: left;">
		                <input name="verifyCode" type="text" class="input-height-sm " placeholder="请输入您的验证码" style="width: 50%;padding-right:5%;padding-left:5%;">
		                <input type="button"  value="获取验证码" id="btnGetVerifyCode" class="input-height-sm bg-yellow" style=" float: right;width: 35%;height: 2.4em;" onclick="getVerifyCode();" />
		            </div>
		            <div class="row">
		                <input type="button" value="预约并关注" id="btnPreOrder" class="input-height-lg bg-yellow" style="width: 100%;" />
		            </div>
		        </div>
		    </c:when>
		    <c:otherwise>
                <div class="div-house-inf">
                    <img src="<%=contextPath %>/images/activity/1210shilihe/500yuan.png"/>
                </div>
		    </c:otherwise>
		</c:choose>
	</div>
	<input type="hidden" name="weixinId" value="${weixinId}"/>
    <input type="hidden" name="activityId" value="1"/>
    <input type="hidden" name="ordered" value="${ordered}"/>
    <input type="hidden" name="activityValid" value="${activityValid}"/>
    <input type="hidden" name="ctxPath" value="<%=contextPath%>">
    <input type="hidden" name="moveTo" value="${moveTo}" />
    <input type="hidden" name="accessToken" value="${accessToken}" />
</form>
</body></html>
