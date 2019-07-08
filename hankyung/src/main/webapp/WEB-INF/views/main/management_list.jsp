<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/common.css?v=1">
<link rel="stylesheet" href="${path}/resources/css/main_common.css?v=1">
<meta charset="UTF-8">
<title>학생관리</title>
<style type="text/css">
.content_area{
	background-color: #F8F9FC;
}
.container_box{
	/* border:1px solid black; */
	height: 500px;
}
.container_header{
	margin: 0 auto;
	width: 80%;
	height: 64px;
	border: 2px solid lightgray;
	border-bottom:0px;
	padding: 16px 20px;
	font-size: 20px;
}
.student{
	display:inline-block;
	width: 100px;
	border-right:1px dashed gray;
	text-align: center;
}
.list_box{
	margin: 0 auto;
	width: 80%;
	border: 2px solid lightgray;
	border-bottom: 0px;
}
.list_box_header{
	display: flex;
	background-color: white;
	position: relative;
}
.list_box_title{
	background-color: #efefef;
}
.list_box_header > div{
	text-align: center;
	height: 40px;
	line-height: 40px;
	color: gray;
	font-size: 15px;
	font-weight: 600;
}
.list_box_header > div > input{
	text-align: center;
}
.info_line{
	border-left: 2px solid lightgray;
	border-bottom: 2px solid lightgray;
	
}
.flex_line2{
	flex:2;
}
.flex_line3{
	flex:3;
}
.num{
	flex: 1;
	border-bottom: 2px solid lightgray;
}
.info_box{
	border: none;
	outline: none;
	padding: 10px;
	width: 100%;
	height: 100%;
	background-color: white;
}
</style>
</head>
<body>
	<div class="list_box">
		<div class="list_box_header list_box_title">
			<div class="num">No.</div>
			<div class="name info_line flex_line2">이름</div>
			<div class="email info_line flex_line3">이메일</div>
			<div class="phone info_line flex_line3">전화번호</div>
			<div class="id info_line flex_line2">아이디</div>
			<div class="pw info_line flex_line2">비밀번호</div>
		</div>	
		
		<c:forEach items="${list}" var="mDto" varStatus="status">
				<div class="list_box_header">
					<div class="num">
						<input id="input_num" name="num" class="info_box" value="${status.index+1}" readonly="readonly" style = "text-align:center;">
					</div>
					<div class="name info_line flex_line2">
						<input id="input_name" name="name" class="info_box" value="${mDto.name}" readonly="readonly">
					</div>
					<div class="email info_line flex_line3">
						<input id="input_email" name="email"class="info_box" value="${mDto.email}" readonly="readonly">
					</div>
					<div class="phone info_line flex_line3">
						<input id="input_phone" name="phone" class="info_box" value="${mDto.phone}" readonly="readonly">
					</div>
					<div class="id info_line flex_line2">
						<input id="input_id" name="id" class="imput_id info_box" value="${mDto.id}" readonly="readonly">
					</div>
					<div class="pw info_line flex_line2">
						<input id="input_pw" name="pw" type="password" class="info_box" value="${mDto.pw}" readonly="readonly">
					</div>
				</div>
		</c:forEach>	
	</div>		
</body>
</html>
