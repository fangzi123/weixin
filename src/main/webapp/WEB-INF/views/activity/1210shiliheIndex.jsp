<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>3000元租不到好公寓？我不许你这么说</title>
<link rel="stylesheet" href="<%=contextPath %>/resources/css/activity/jquery.fullPage.css">
<style>
* { margin: 0; padding: 0;}
body { font: 16px/1.8 "Microsoft Yahei",verdana;}

img {
        width: 195%;
}

img.img-02 {
        width: 100%;
}

img.img-03 {
        width: 230%;
}
img.img-04 {
        width: 199%;
}
img.img-05 {
        width: 160%;
}
div#b1 {
        margin-top: 58em;
        width: 60%;
        margin-left: 19%;
        height: 350px;
}

input.inp {
        width: 800px;
        height: 100px;
        padding-top: 10%;
        padding-left: 20%;
        font-size: 2em;
        border-radius: 30px;
        border: 0;
}
input#inp-2 {
        width: 400px;
}
        img.follow {
        width: 380px;
        height: 100px;
        border-radius: 30px;
        border: 0;
        position: relative;
        left: 27em;
        bottom: 6em;
}

span.sp1 {
        position: relative;
        bottom: 4em;
}

img#fol {
        position: relative;
        width: 50em;
        height: 100px;
        border-radius: 30px;
        border: 0;
        bottom: 3em;
}
input#inp-1 {
        margin-bottom: 1em;
}

img#img10 {
        position: relative;
        top: 30px;
        width: 100%;
}
img.img-00 {
        width: 100%;
}
#fullPage-nav { _display: none; font-size: 12px;display: none;}
#fullPage-nav li { width: 90px; height: 21px; margin: 10px 0 0; vertical-align: middle;}
#fullPage-nav li a { float: right; width: 21px; height: 21px; color: #8F9DA4; text-decoration: none; text-align: right; background: url(images/dot.png) 5px 5px no-repeat;}
#fullPage-nav li .active { background-position: 0 bottom;}
#fullPage-nav span { display: none;}
.fullPage-tooltip { float: left; top: 0; margin-right: 5px; font: 12px "Microsoft Yahei"; color: #8F9DA4; line-height: 21px;}

.section { position: relative; overflow: hidden;}
.section .bg { position: absolute; left: 0; top: 0; width: 100%; height: 100%;}
.section .bg img { display: block; width: 100%; height: 100%;}

.bg11 { position: absolute; bottom: 0; width: 100%; height: 850px; background: url(images/bg11.png) 50% 0 no-repeat; transition: all 1s;}
.bg12 { position: absolute; bottom: -392px; width: 100%; height: 392px; background: url(images/bg12.png) 50% 0 no-repeat; opacity: 0; transition: all 1.7s; bottom: 90px\0;}
.bg13 { position: absolute; bottom: -377px; width: 100%; height: 377px; background: url(images/bg13.png) 50% 0 no-repeat; transition: all 1s;}
.hgroup { position: absolute; width: 554px; height: 176px; left: 50%; top: 25%; margin: 0 0 0 -277px; text-indent: -9999px; background-image: url(images/slogan.png); opacity: 0; -webkit-transform:scale(0.5, 0.5); transform:scale(0.5, 0.5); transition: all 1s;}
.p11 { position: absolute; left: 25%; top: 75%; width: 600px; margin: 0 0 0 -280px; font-size: 14px; color: #94a7c6; opacity: 0; transition: all 0.3s;}
.mail { position: absolute; left: 50%; top: -26px; width: 375px; height: 26px; margin-left: -187px; background-image: url(images/logo.png); transition: all 1s;}
.mail { float: left; height: 26px; text-indent: -9999px;}
.mail-163 { float: left; width: 107px;}
.mail-126 { float: left;width: 108px; margin-left: 23px;}
.mail-yeah { float: right; width: 115px;}

.bg21 { position: absolute; left: 50%; bottom: 15%; width: 819px; height: 250px; margin-left: -608px; margin-bottom: 40px; background: url(images/bg21.png) 0 0 no-repeat; transition: all 1s;  opacity: 0; margin-left: -1108px;}
.bg22 { position: absolute; left: 50%; bottom: 15%; width: 819px; height: 299px; margin-left: -280px; margin-bottom: 70px; background: url(images/bg22.png) right 0 no-repeat; transition: all 1s; opacity: 0; margin-left: 320px;}
.bg23 { position: absolute; left: 50%; bottom: 15%; width: 819px; height: 325px; margin-left: -409px; background: url(images/bg23.png) 50% 0 no-repeat; transition: all 1s;  bottom: -40%;}
.section strong { position: absolute; left: 50%; top: 15%; z-index: 10; width: 512px; height: 45px; margin-left: -256px; font-size: 24px; font-weight: 500; color: #748A9E; opacity: 0; -webkit-transform:scale(0.5, 0.5); transform:scale(0.5, 0.5); transition: all 1s;}
.section h3 { position: absolute; left: 50%; top: 15%; z-index: 10; width: 512px; height: 45px; margin-left: -256px; margin-top: 60px; text-indent: -9999px; background-repeat: no-repeat; opacity: 0; -webkit-transform:scale(0.5, 0.5); transform:scale(0.5, 0.5); transition: all 1s;}
.p1 { position: absolute;left: 60%;top: 60%;width: 300px;transition: all 1s;}
p.p00 {position: absolute;left: 10%;top: 10%;width: 300px;transition: all 1s;}

.section6 strong { width: 561px; margin-left: -280px;}
.section6 h3 { width: 561px; margin-left: -280px; background-image: url(images/t6.png);}
.section7 strong { width: 561px; margin-left: -280px;}
.section7 h3 { width: 561px; margin-left: -280px; background-image: url(images/t7.png);}
.section8 strong { width: 561px; margin-left: -280px;}
.section8 h3 { width: 561px; margin-left: -280px; background-image: url(images/t8.png);}
.section9 strong { width: 609px; margin-left: -304px;}
.section9 h3 { width: 609px; margin-left: -304px; background-image: url(images/t9.png);}
.section9 h3 span { position: absolute; left: -100px; top: -48px; width: 89px; height: 90px; background-image: url(images/yixin.png);}

.bg31 { position: absolute; left: 50%; bottom: 0; width: 892px; height: 472px; margin-left: -396px; margin-bottom: 80px; background-image: url(images/bg31.png); opacity: 0; transition: all 1s;}
.bg32 { position: absolute; left: 50%; bottom: 0; width: 892px; height: 472px; margin-left: -396px; background: url(images/bg32.png) 470px bottom no-repeat; opacity: 0; transition: all 1s;}
.bg33 { position: absolute; left: 50%; bottom: 0; width: 441px; height: 380px; margin-left: 50%; background: url(images/bg33.png) 0 0 no-repeat; opacity: 0; transition: all 1s;}
.p3 { position: absolute; width: 430px; left: 48%; top: 64%; margin-top: 250px; margin-left: -100%; font-size: 16px; color: #FFFDE1; opacity: 0; transition: all 1s;}
</style>
<script src="<%=contextPath %>/commonJS/jquery/jquery-1.8.3.js"></script>
<script src="<%=contextPath %>/resources/js/activity/jquery-ui-1.10.3.min.js"></script>
<script src="<%=contextPath %>/resources/js/activity/jquery.fullPage.min.js"></script>
<script src="<%=contextPath %>/mvcjs/activity/1210shiliheIndex.js"></script>
<script src="<%=contextPath %>/mvcjs/activity/weixin.js"></script>
</head>
<body>
<form id="shiliheIndex" action="shilihe_detail">
	<div class="section section2">
	    <div class="bg"><img src="<%=contextPath %>/images/activity/1210shilihe/index.png" alt=""></div>
	    <div class="bg21"></div>
	    <div class="bg22"></div>
	    <div class="bg23"></div>
	    <p class="p1"><a href="javascript:void(0);" onclick="getActivityDetail('1');"><img class="img-02" src="<%=contextPath %>/images/activity/1210shilihe/btn1.png"></a></p>
	    <p class="p00"><a href="javascript:void(0);" onclick="getActivityDetail('2');"><img class="img-00" src="<%=contextPath %>/images/activity/1210shilihe/btn2.png"></a></p>
	</div>

    <input type="hidden" name="weixinId" value="${weixinId}"/>
    <input type="hidden" name="activityId" value="1"/>
    <input type="hidden" name="gender" />
    <input type="hidden" name="moveTo" value="${moveTo}" />
    <input type="hidden" name="accessToken" value="${accessToken}" />
</form>
</body>
</html>
