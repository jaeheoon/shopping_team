package getbag.shopping.domain.support.dao;

import java.sql.Connection;
import java.util.List;

import getbag.shopping.domain.support.dto.Support;

/**
 * 데이터 베이스 문의 관리 명세
 *  @author 홍재헌
 *
 */
public interface SupportDao {
	//문의 등록
	public Support create(Connection connection, Support support);
	//문의 제목으로 출력
	public Support findByCode(Connection connection, String code);
	//문의 전체 출력
	public List<Support> findByAll(Connection connection);
}
