package getbag.shopping.domain.support.dto;

/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * 게시글 정보
 * @author 홍재헌
 *
 */
public class Support {
//	qnacode는 db 내 시퀀스로 동작, qnadate는 db 내 sysdate로 동작
//									   설명           		 - DB에 등록된 이름
	private String qnacode; 			// 문의 코드    	 - qnacode - db에서 가져와서 저장하는 역할, 따로 생성자에서 등록은 안해준다
	private String procode; 			// 상품 아이디    	 - procode
	private String qnatitle; 			// 문의 제목    	 - qnatitle
	private String qnacont; 			// 문의 내용    	 - qnacont
	private String qnaauth; 			// 작성자 아이디     - qnaauth

	public Support() {}

	public Support(String procode, String qnatitle, String qnacont, String qnaauth ) {
		super();
		this.procode = procode;
		this.qnatitle = qnatitle;
		this.qnacont = qnacont;
		this.qnaauth = qnaauth;
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public String getQnatitle() {
		return qnatitle;
	}

	public void setQnatitle(String qnatitle) {
		this.qnatitle = qnatitle;
	}

	public String getQnacont() {
		return qnacont;
	}

	public void setQnacont(String qnacont) {
		this.qnacont = qnacont;
	}

	public String getQnaauth() {
		return qnaauth;
	}

	public void setQnaauth(String qnaauth) {
		this.qnaauth = qnaauth;
	}
	
	public String getQnacode() {
		return qnacode;
	}

	public void setQnacode(String qnacode) {
		this.qnacode = qnacode;
	}

	@Override
	public String toString() {
		return "Support [문의 번호=" + qnacode + ", 상품 코드=" + procode + ", 문의 제목=" + qnatitle + ", 문의 내용=" + qnacont + ", 문의 작성자=" + qnaauth + "]";
	}
	
}
