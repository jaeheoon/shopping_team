package getbag.shopping.domain.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import getbag.shopping.domain.member.dto.Member;
import getbag.shopping.domain.product.dto.Product;

/**
 * RDB를 통해 상품 저장 및 관리(검색, 수정, 삭제) 구현체
 * @author 홍재헌
 */
public class JdbcProductDao  implements ProductDao {
	
	/**
	 * 신규상품 등록
	 */
	public boolean create(Connection connection,  Product product){
		boolean success = false;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO product (")
		  .append("  procode,")
		  .append("  catecode,")
		  .append("  proname,")
		  .append("  proprice,")
		  .append("  prosale,")
		  .append("  proinfo,")
		  .append("  proqty,")
		  .append("  prothumb,")
		  .append("  proimg)")
		  .append(" VALUES (procode_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, product.getCatecode());
			pstmt.setString(2, product.getProname());
			pstmt.setString(3, product.getProprice());
			pstmt.setString(4, product.getProsale());
			pstmt.setString(5, product.getProinfo());
			pstmt.setString(6, product.getProqty());
			pstmt.setString(7, product.getProthumb());
			pstmt.setString(8, product.getProimg());
			pstmt.executeUpdate();
			success = true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return success;
	}
	
	public Product findByName(Connection connection, String proname) {
		Member member = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate FROM product")
		  .append(" WHERE id = ? AND passwd = ?");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, proname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String regdate = rs.getString("regdate");
				member = new Member();
				member.setId(uid);
				member.setName(uname);
				member.setRegdate(regdate);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return null;
	}
	
	@Override
	public List<Product> findByAll(Connection connection) {
		List<Product> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, TO_CHAR(birthday, 'yyyy-MM-DD DAY') birthday, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate FROM member");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while (rs.next()) {			
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String birthday = rs.getString("birthday");
				String regdate = rs.getString("regdate");
				Member member = new Member();
				member.setId(uid);
				member.setName(uname);
				member.setbirthday(birthday);
				member.setRegdate(regdate);
//				list.add(member);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	@Override
	public Product findByNum(Connection connection, String catecode) {
		Member member = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, passwd, name, TO_CHAR(birthday, 'yyyy-MM-DD DAY') birthday, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate")
		  .append(" FROM member")
		  .append(" WHERE id = ?");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, catecode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String birthday = rs.getString("birthday");
				String regdate = rs.getString("regdate");
				member.setId(uid);
				member.setName(uname);
				member.setbirthday(birthday);
				member.setRegdate(regdate);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return null;
	}
	
}


















