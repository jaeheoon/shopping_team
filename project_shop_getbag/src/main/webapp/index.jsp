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
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
  <!-- =============== Header =============== -->
  <jsp:include page="/modules/header.jsp" />
  

  <!-- =============== Main =============== -->
  <main class="main1">
    <img src="img/main1.jpg" class="mainImg">
    <div class="mainItems">
      <div class="row">
        <div class="col-3 p-0">
          <a href="<%=request.getContextPath()%>/product/product-detail.jsp"><img src="img/sample1.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="<%=request.getContextPath()%>/product/product-detail.jsp"><img src="img/sample1.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="<%=request.getContextPath()%>/product/product-detail.jsp"><img src="img/sample1.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="<%=request.getContextPath()%>/product/product-detail.jsp"><img src="img/sample1.jpg" alt="" class="mainItem"></a>
        </div>
      </div>
      
      <div class="row">
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample2.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample2.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample2.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample2.jpg" alt="" class="mainItem"></a>
        </div>
      </div>
    </div>
  </main>

  <main class="main2">
    <img src="img/main2.jpg" class="mainImg">
    <div class="mainItems">
      <div class="row">
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample3.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample3.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample3.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample3.jpg" alt="" class="mainItem"></a>
        </div>
      </div>

      <div class="row">
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample4.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample4.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample4.jpg" alt="" class="mainItem"></a>
        </div>
        <div class="col-3 p-0">
          <a href="#"><img src="img/sample4.jpg" alt="" class="mainItem"></a>
        </div>
      </div>
    </div>
  </main>



  <!-- =============== Footer =============== -->
  <jsp:include page="/modules/footer.jsp" />


  <!-- JavaScript Libraries -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>