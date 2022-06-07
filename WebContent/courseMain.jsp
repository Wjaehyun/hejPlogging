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
	<title>플러깅 코스</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="assets/css/productMain.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="Nav.jsp"/>
	<section>
		<div class="inside">
			<!-- 페이지 이름 -->
			<div class="page-name">
				<h5><span><strong>플로깅 코스</strong></span></h5>
				<span>어디까지 주워 봤니? 헤이,플러깅이 소개하는 전국의 모든 플러깅 코스</span>
			</div>
			<!-- hr -->
			<div class="hr-wrapper">
				<hr>
			</div>
			<!-- 카테고리 -->
			<div class="category-container">
				<div class="category-name category-wrapper">
					<span>지역</span>
				</div>
				<div class="category-list category-wrapper">
					<ul class="category">
						<li class="category"><a href="">전체</a></li>
						<li class="category"><a href="">서울</a></li>
						<li class="category"><a href="">경기</a></li>
						<li class="category"><a href="">인천</a></li>
						<li class="category"><a href="">경상</a></li>
						<li class="category"><a href="">대구</a></li>
					</ul>
				</div>
			</div>
			<div class="product-container">
				<!-- hr -->
				<div class="hr-wrapper">
					<hr>
				</div>
				<!-- 정렬 - select -->
				<div class="product-sort">
					<select name="sort" id="sort">
						<option value="recent">등록순</option>
						<option value="like" selected>인기순</option>
						<option value="min_distance">짧은거리순</option>
						<option value="max_distance">긴거리순</option>
						<option value="point">포인트많은순</option>
						<option value="asc">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
				</div>
				<!-- 3칸 목록 -->
            <div class="product-list-container" id="wrap-3">
            <c:set var="i" value="0" />
            <c:set var="j" value="3" />
            <c:forEach var="course" items="${courseList}">
                  <c:if test="${i%j == 0 }">
                  <div class="row">
                  </c:if>
                     <div class="col">
                        <div class="product-img-wrapper">
                           <a href="${pageContext.request.contextPath }/courseDetail.cs?courseNumber=${course.getCourseNumber()}&page=${page}"><img src="D:\\web_1900_jhs\\jsp\\workspace\\1teamWeb\\WebContent\\upload\\${course.getFileNameOriginal()}"></a>
                        </div>
                        <div class="product-detail">
                           <div class="product-name">
                              <a href="courseSpecific.jsp"></a>
                              <a href="">
                              <c:out value="${course.getCourseName()}"/>
                              </a>
                           </div>
                        </div>
                     </div>
                  <c:if test="${i%j == j-1 }">   
                  </div>
                  </c:if>
                  <c:set var="i" value="${i+1}" />         
            </c:forEach> 
            <c:set var="page" value="${page}"/>
			<c:set var="startPage" value="${startPage}"/>
			<c:set var="endPage" value="${endPage}"/>
			<c:set var="realEndPage" value="${realEndPage}"/>
			<c:set var="total" value="${total}"/>
				<table style="font-size:1.3rem">
					<tr align="center" align="middle">
						<td class="web-view">
							<c:if test="${startPage > 1}">
								<a href="${pageContext.request.contextPath}/courseMainInfo.cs?page=${startPage - 1}">&lt;</a>
							</c:if>
												
						<c:forEach var="z" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${z eq page}">
									<c:out value="${z}"/>&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/courseMainInfo.cs?page=${z}">
										<c:out value="${z}"/>
									</a>&nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
													
						<c:if test="${endPage < realEndPage}">
							<a href="${pageContext.request.contextPath}/courseMainInfo.cs?page=${endPage + 1}">&gt;</a>
						</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>