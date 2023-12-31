document.write('<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.20/dist/sweetalert2.all.min.js"></script>');

$(document).ready(function() {
	
	// 비밀번호 passwordComplexity 제약조건
	  $.validator.addMethod("passwordComplexity", function(value, element) {
	  return /^(?=.*\d)(?=.*[a-zA-Z])(?=.*[\W_]).{8,}$/.test(value);
  }, "비밀번호는 최소 8자 이상이며, 숫자, 영문, 특수문자를 포함해야 합니다.");
  
	// 아이디 id 제약조건
    $.validator.addMethod("idComplexity", function(value, element) {
        return /^(?=.*[a-zA-Z])(?=.*\d).{4,}$/.test(value);
    }, "아이디는 최소 4자 이상이며, 영문과 숫자를 모두 포함해야 합니다.");
	
	
  $("#formValidation").validate({
    rules: {
      name: {
        required: true,
        minlength: 2
      },
	  id: {
		  required: true,
		  idComplexity: true
	  },
	  passwd: {
		required: true,
        passwordComplexity: true
	  },
	  aggrement: {
		  required: true
	  }
    },
    messages: {
      name: {
        required: "이름을 입력해주세요.",
        minlength: "이름은 최소 2자 이상 입력해야 합니다."
      },
	  id: {
		  required: "아이디를 입력해주세요.",
		  idComplexity: "아이디는 최소 4자 이상이며, 영문과 숫자를 모두 포함해야 합니다."
	  },
	  passwd: {
        required: "비밀번호를 입력해 주세요.",
        passwordComplexity: "비밀번호는 최소 8자 이상이며, 숫자, 영문, 특수문자를 포함해야 합니다."
      },
      aggrement: {
		  required: "개인정보 수집 및 이용 동의에 체크해 주세요.",
	  }
    }
  });
  
  // 오류메세지 SweetAlert 처리
  function showErrorAlert(message) {
    Swal.fire({
      icon: 'error',
      title: '오류',
      text: message,
      confirmButtonText: '확인'
    });
  }
  
  // 가입완료 버튼 클릭 시 양식 제출을 수동으로 처리
  $("#signUpBtn").on("click", function(e) {
    e.preventDefault(); // Prevent default form submission

    if ($("#formValidation").valid() && $("#aggrement").is(":checked")) {
      $("#formValidation")[0].submit();
    } else {
      showErrorAlert("모든 필수 항목을 올바르게 입력해주세요.");
    }
  });
  
});