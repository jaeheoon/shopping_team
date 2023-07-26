package getbag.shopping.domain.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import getbag.shopping.domain.support.dto.Support;

/**
 * RDB를 통해 고객센터 문의글 저장 및 관리(검색, 수정, 삭제) 구현체
 * 
 * @author 홍재헌
 */
public class JdbcSupportDao implements SupportDao {

	/**
	 * 신규 문의 등록
	 */
	public Support create(Connection connection, Support support) {
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO product_qna (")
		  .append("		    qnacode,")
		  .append("		    qnatitle,")
		  .append("		    qnacont,")
		  .append("		    qnadate,")
		  .append("		    qnaauth")
		  .append(" ) VALUES (qnacode_seq.nextval, ?, ?, sysdate, ?)");

		StringBuilder sb2 = new StringBuilder();
		sb2.append(" SELECT qnacode_seq.currval qnacode")
		   .append(" FROM DUAL");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, support.getQnatitle());
			pstmt.setString(2, support.getQnacont());
			pstmt.setString(3, support.getQnaauth());
			pstmt.executeUpdate();
			pstmt.close();

			pstmt = connection.prepareStatement(sb2.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String qnaCode = rs.getString("qnacode");
				support.setQnacode(qnaCode);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return support;
	}
	
	/**
	 * 문의 번호로 글 찾기
	 */
	public Support findByCode(Connection connection, String code) {
		Support support = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM team.product_qna").append(" WHERE qnacode = ?");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String qnacode = rs.getString("qnacode");
				String qnatitle = rs.getString("qnatitle");
				String cont = rs.getString("qnacont");
				String auth = rs.getString("qnaauth");
				support = new Support();
				support.setQnacode(qnacode);
				support.setQnatitle(qnatitle);
				support.setQnacont(cont);
				support.setQnaauth(auth);
			}

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {}
		}
		return support;
	}

	/**
	 * 문의 내용 전체 찾기
	 */
	@Override
	public List<Support> findByAll(Connection connection) {
		List<Support> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM team.product_qna");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Support support = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<Support>();
			while (rs.next()) {
				String qnacode = rs.getString("qnacode");
				String qnatitle = rs.getString("qnatitle");
				String cont = rs.getString("qnacont");
				String auth = rs.getString("qnaauth");
				support = new Support();
				support.setQnacode(qnacode);
				support.setQnatitle(qnatitle);
				support.setQnacont(cont);
				support.setQnaauth(auth);
				list.add(support);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {}
		}
		return list;
	}

}
