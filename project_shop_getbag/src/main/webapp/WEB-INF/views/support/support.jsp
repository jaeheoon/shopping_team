<%@page import="getbag.shopping.domain.common.factory.ServiceFactory"%>
<%@page import="getbag.shopping.domain.support.dto.Support"%>
<%@page import="getbag.shopping.domain.support.dto.SupportRe"%>
<%@page import="getbag.shopping.domain.support.service.SupportService"%>
<%@page import="getbag.shopping.domain.support.service.SupportReService"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- BootStrap -->
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="../css/style.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

</head>

<body>
	<!-- =============== Header =============== -->
	<jsp:include page="/WEB-INF/views/modules/header.jsp" />

	<!-- =============== Support-value =============== -->
	<%
	String recode = request.getParameter("recode");
	SupportService supportService = ServiceFactory.getInstance().getSupportService();
	SupportReService supportReService = ServiceFactory.getInstance().getSupportReService();

	List<Support> list = supportService.readSupport();

	Support[] supports = new Support[list.size()];
	SupportRe[] supportRes = new SupportRe[list.size()];
	String[] qnaCodes = new String[list.size()];

	for (int i = 0; i < list.size(); i++) {
		supports[i] = list.get(i);
		supportRes[i] = supportReService.readNumSupportRe(list.get(i).getQnacode());
	}
	%>

	<c:forEach items="${supports}" var="support" varStatus="status">
		<p>${support.getQnatitle()}</p>
	</c:forEach>


	<!-- =============== Article(Support) =============== -->
	<section class="support container">
		<div class="border-bottom border-2 border-black mt-5">
			<div class="d-flex align-items-center mb-4">
				<h4 class="mb-0 me-3 fw-bold">고객센터</h4>
				<p class="mb-0 m-1">문의사항을 남겨주시면 빠른 시일 내에 답변해드리도록 하겠습니다.</p>
			</div>
		</div>
		<form action="">
			<div class="p-5">
				<textarea class="form-control border-dark-subtle border-3 p-3"
					id="exampleFormControlTextarea1" rows="2"
					placeholder="문의사항을 입력해주세요."></textarea>
				<div class="d-md-flex justify-content-end align-items-center mt-4">
					<input type="submit" value="작성하기" id="sendBtn"
						class="btn btn-dark btn-sm ps-5 pe-5">
				</div>
			</div>
		</form>
		<div class="border-bottom border-2 border-dark-subtle mt-3 ms-2">
			<div class="d-flex align-items-center mb-4">
				<h5 class="mb-0">문의목록</h5>
			</div>
		</div>

		<!-- ======================Accordion Item 1====================== -->
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingOne">
				<button class="accordion-button collapsed border-bottom p-4"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#flush-collapseOne" aria-expanded="false"
					aria-controls="flush-collapseOne">
					<p class="mb-0">
						Q.
						<%=supports[0].getQnatitle()%></p>
				</button>
			</h2>
			<div id="flush-collapseOne" class="accordion-collapse collapse lh-lg"
				aria-labelledby="flush-headingOne"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body p-4">

					<%=supportRes[0].getReCont()%>

				</div>
			</div>
		</div>

		<!-- ======================Accordion Item 2====================== -->
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingTwo">
				<button
					class="accordion-button collapsed border-top border-bottom p-4"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#flush-collapseTwo" aria-expanded="false"
					aria-controls="flush-collapseTwo">
					<p class="mb-0">
						Q.
						<%=supports[1].getQnatitle()%></p>
				</button>
			</h2>
			<div id="flush-collapseTwo" class="accordion-collapse collapse lh-lg"
				aria-labelledby="flush-headingTwo"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body p-4">

					<%=supportRes[1].getReCont()%>

				</div>
			</div>
		</div>

		<!-- ======================Accordion Item 3====================== -->
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingThree">
				<button
					class="accordion-button collapsed border-top border-bottom p-4"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#flush-collapseThree" aria-expanded="false"
					aria-controls="flush-collapseThree">
					<p class="mb-0">
						Q.
						<%=supports[2].getQnatitle()%></p>
				</button>
			</h2>
			<div id="flush-collapseThree"
				class="accordion-collapse collapse lh-lg"
				aria-labelledby="flush-headingThree"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body p-4">

					<%=supportRes[2].getReCont()%>

				</div>
			</div>
		</div>


		<!-- page nav-->
		<div class="d-flex justify-content-center mt-5">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true"><strong>&laquo;</strong></span>
					</a></li>
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="#" style="color: white !important;">1</a>
					</li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true"><strong>&raquo;</strong></span>
					</a></li>
				</ul>
			</nav>
		</div>
	</section>


	<!-- =============== Footer =============== -->
	<jsp:include page="/WEB-INF/views/modules/footer.jsp" />


	<!-- JavaScript Libraries -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>