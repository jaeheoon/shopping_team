<%@page import="getbag.shopping.domain.product.dto.Product"%>
<%@page import="getbag.shopping.domain.common.factory.ServiceFactory"%>
<%@page import="getbag.shopping.domain.product.service.ProductService"%>
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
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="/css/style.css" rel="stylesheet">
</head>

<body>
  <!-- =============== Header =============== -->
  <jsp:include page="/WEB-INF/views/modules/header.jsp" />
  
  <!-- =============== Product-value =============== -->
  <%
  String procode = request.getParameter("procode");
  ProductService productService = ServiceFactory.getInstance().getProductService();
  
  Product product = productService.readNumProduct(procode);
  
  String pimageqty = product.getPimageqty();
  String[] pimages = pimageqty.split(",");
  System.out.println(pimages[2]);
  %>

  <!-- =============== Product-detail =============== -->
  <div class="productDetail">
    <div class="container">
      <h5 class="mb-4 mt-5 ms-3">홈페이지 > 상품 > <%= product.getCategory() %></h5>
      <div class="row">
        <div class="col-6 mb-5">
          <img src="<%=request.getContextPath()%>/img/<%= product.getColor() %>/<%= pimages[0] %>" alt="" class="product-detail border-bottom-0">
          <img src="<%=request.getContextPath()%>/img/<%= product.getColor() %>/<%= pimages[1] %>" alt="" class="product-detail border-bottom-0">
          <img src="<%=request.getContextPath()%>/img/<%= product.getColor() %>/<%= pimages[2] %>" alt="" class="product-detail">
        </div>
        <div class="col-6">
          <div style="margin-left: 15%;">
          	<h3 class="mb-3 mt-4 fw-bold">[<%= product.getBrand() %>]&nbsp;&nbsp;<%= product.getPname() %></h3>
            <h5 class="fw-bold mb-5">₩ <%= product.getPrice() %></h5>
            <ul class="mb-5">
            	<%= product.getDescription() %>
            </ul>
            <a href="<%=request.getContextPath()%>/getbag/basket-contain"><button class="btn btn-simple mb-3" type="submit">장바구니에 추가</button></a>
            <a href="<%=request.getContextPath()%>/getbag/wish-contain"><button class="btn btn-white mb-3" type="submit">위시리스트에 추가</button></a>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- =============== floating =============== -->
  <jsp:include page="/WEB-INF/views/modules/floating.jsp" />

  <!-- =============== Footer =============== -->
  <jsp:include page="/WEB-INF/views/modules/footer.jsp" />

	<!-- JavaScript Libraries -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>