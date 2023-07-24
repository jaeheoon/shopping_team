package getbag.shopping.web.work.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getbag.shopping.web.mvc.controller.HttpController;

/**
 * 회원 로그인 및 로그아웃 처리 세부 컨트롤러
 * /member/signin
 */
public class MemberSigninController implements HttpController {
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		String viewName = "redirect:/";
		
		return viewName;
	}
}
