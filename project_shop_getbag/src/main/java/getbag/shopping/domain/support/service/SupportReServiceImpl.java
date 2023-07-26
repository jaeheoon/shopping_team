package getbag.shopping.domain.support.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import getbag.shopping.domain.common.factory.ServiceFactory;
import getbag.shopping.domain.support.dao.SupportReDao;
import getbag.shopping.domain.support.dto.SupportRe;

/**
 * 고객센터 답변 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
public class SupportReServiceImpl implements SupportReService{
	
	private DataSource dataSource;
	private SupportReDao supportReDao;
	
	public SupportReServiceImpl(DataSource dataSource, SupportReDao supportReDao) {
		this.dataSource = dataSource;
		this.supportReDao = supportReDao;
	}

	@Override
	public SupportRe registerSupport(SupportRe supportRe) {
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			// 등록
			supportRe = supportReDao.create(connection, supportRe);
			// 상세조회
			supportRe = supportReDao.findByCode(connection, supportRe.getReCode());
			// 정상 처리 시 커밋
			connection.commit();
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return supportRe;
	}
	
	@Override
	public SupportRe readNumSupportRe(String code) {
		SupportRe supportRe = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			supportRe = supportReDao.findByCode(connection, code);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return supportRe;
	}
	
	// 테스트 메인
	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		
//		문의 답변 관련 테스트------------------------------------------------------------------------------------------------------------------------------------------------------
		SupportReService supportReService = serviceFactory.getSupportReService();
		SupportRe supportRe = null;
//		supportRe = new SupportRe("4", "답변 테스트입니다");
//		supportRe = supportReService.registerSupport(supportRe);
//		System.out.println("등록 후 상세정보 : " + supportRe);
		
		supportRe = supportReService.readNumSupportRe("4");
		System.out.println("검색된 상세정보 : " + supportRe);
		
		
		
	}

}
