<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<div class="floating">
    <ul>
     <li><a href="<%=request.getContextPath()%>/member/basket-empty.jsp"><i class="bi bi-cart2" style="font-size: 3rem;"></i></a></li>
     <li><a href="#"><i class="bi bi-arrow-up-circle" style="font-size: 3rem;"></i></a></li>
    </ul>
   </div>


  <!-- Add any necessary JavaScript or external JS files here -->
  <script>
    // Debounce function to delay the execution of the scroll event handling
    function debounce(func, wait, immediate) {
      let timeout;
      return function () {
        const context = this;
        const args = arguments;
        const later = function () {
          timeout = null;
          if (!immediate) func.apply(context, args);
        };
        const callNow = immediate && !timeout;
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
        if (callNow) func.apply(context, args);
      };
    }
    // Function to show/hide the floating div based on the scroll position
    function toggleFloatingDiv() {
      var floatingDiv = document.querySelector('.floating');
      var scrollPosition = window.scrollY || window.pageYOffset;
      if (scrollPosition > 100) { // Adjust the scroll position as needed
        floatingDiv.style.display = 'block';
        floatingDiv.style.opacity = 1;
      } else {
        floatingDiv.style.opacity = 0;
        setTimeout(function () {
          floatingDiv.style.display = 'none';
        }, 500); // Adjust the timeout to match the transition duration in CSS
      }
    }
    // Add event listener for debounced scroll event
    window.addEventListener('scroll', debounce(toggleFloatingDiv, 200));
  </script>