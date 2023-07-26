package getbag.shopping.domain.support.dto;

/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * 게시글 정보
 * @author 홍재헌
 *
 */
public class Support {
//	qnacode는 db 내 시퀀스로 동작, qnadate는 db 내 sysdate로 동작
//									   		설명           	 - DB에 등록된 이름
	private String qnaCode; 			// 문의 코드    	 - qnacode - db에서 가져와서 저장하는 역할, 따로 생성자에서 등록은 안해준다
	private String proCode; 			// 상품 아이디    	 - procode
	private String qnaTitle; 			// 문의 제목    	 - qnatitle
	private String qnaCont; 			// 문의 내용    	 - qnacont
	private String qnaAuth; 			// 작성자 아이디     - qnaauth

	public Support() {}

	public Support(String qnaTitle, String qnaCont, String qnaAuth ) {
		super();
		this.qnaTitle = qnaTitle;
		this.qnaCont = qnaCont;
		this.qnaAuth = qnaAuth;
	}

	public String getProcode() {
		return proCode;
	}

	public void setProcode(String proCode) {
		this.proCode = proCode;
	}

	public String getQnatitle() {
		return qnaTitle;
	}

	public void setQnatitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnacont() {
		return qnaCont;
	}

	public void setQnacont(String qnaCont) {
		this.qnaCont = qnaCont;
	}

	public String getQnaauth() {
		return qnaAuth;
	}

	public void setQnaauth(String qnaAuth) {
		this.qnaAuth = qnaAuth;
	}
	
	public String getQnacode() {
		return qnaCode;
	}

	public void setQnacode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	@Override
	public String toString() {
		return "Support [문의 번호=" + qnaCode + ", 문의 제목=" + qnaTitle + ", 문의 내용=" + qnaCont + ", 문의 작성자=" + qnaAuth + "]";
	}
	
}
