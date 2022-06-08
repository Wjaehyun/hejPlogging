<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>	
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>코스 - 대구 성당못</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="assets/css/productSpecific.css">
</head>
<body>
	<c:set var="course" value="${courseList}"/>
   	<c:set var="files" value="${files}"/>
   	<c:set var="page" value="${page}"/>
	<jsp:include page="header.jsp"/>
	<jsp:include page="Nav.jsp"/>
	<section>
		<div class="inside">
			<!-- 두 줄: min-width 992px -->
			<div class="product-container" id="wrap-2">
				<!-- 이미지 -->
				<div class="product-thumbs-wrapper">
					<div class="holder">
						<c:forEach var="file" items="${files}" begin="0" end="0">
		                   <img src="/upload/${file.getFileNameOriginal()}">
	                    </c:forEach>
					</div>
				</div>
				<!-- 코스 설명 -->
				<div class="product-form-wrapper">
					<div class="product-form">
						<div class="product-title-wrapper">
								<div class="product-title">
		 							<c:out value="${course.getCourseName()}"/>		
								</div>
							<a><img src="assets/img/share.png" alt=""></a>
						</div>
						<!-- 간단 설명 -->
						<div class="product-summary">
							<span><c:out value="${course.getCourseDetail()}"/></span>
						</div>
					</div>
				</div>
			</div>
			<!-- 한 줄: max-width 991px -->
			<div class="product-container" id="wrap-1">
				<!-- 이미지 -->
				<div class="product-thumbs-wrapper">
					<div class="holder">
						<img src="assets/img/course/seongdangmot.png">
					</div>
				</div>
				<!-- 코스 설명 -->
				<div class="product-form-wrapper">
					<div class="product-form">
						<div class="product-title-wrapper">
							<div class="product-title">
								대구 성당못 코스
							</div>
							<a><img src="assets/img/share.png" alt=""></a>
						</div>
						<!-- 간단 설명 -->
						<div class="product-summary">
							<span>길이 다소 좁긴하나, 갈래길이 많아서 산책하시는 분들 피해서 달리기에 괜찮습니다.</span>
						</div>
					</div>
				</div>
			</div>
			<!-- 상세정보 -->
			<div class="product-detail-wrapper">
				<span>상세정보</span>
				<div class="hr-wrapper">
					<hr>
				</div>
				<div class="product-detail">
					<h3>코스 확인하기</h3>
					<!-- 카카오맵 -->
					<div class="kakaomap">
						<div id="map" style="width:100%;height:400px;"></div>
						<p id="start" style="display:none">
							<c:out value="${course.getCourseStart()}"/>
						</p>
						<p id="end" style="display:none">
							<c:out value="${course.getCourseEnd()}"/>
						</p>
					</div>
					<h3>코스 설명</h3>
					<div class="product-img">
						<c:forEach var="file" items="${files}">
		                   <img src="/upload/${file.getFileNameOriginal()}">
	                    </c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=90266a5ec90bc57cdea6bcfda8c42652&libraries=services"></script>
<script type="text/javascript" src="assets/js/courseSpecific.js"></script>
</html>