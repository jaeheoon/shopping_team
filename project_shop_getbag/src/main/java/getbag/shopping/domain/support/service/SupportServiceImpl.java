package getbag.shopping.domain.support.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import getbag.shopping.domain.common.factory.ServiceFactory;
import getbag.shopping.domain.support.dao.SupportDao;
import getbag.shopping.domain.support.dto.Support;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
public class SupportServiceImpl implements SupportService{
	
	private DataSource dataSource;
	private SupportDao supportDao;
	
	public SupportServiceImpl(DataSource dataSource, SupportDao supportDao) {
		this.dataSource = dataSource;
		this.supportDao = supportDao;
	}

	@Override
	public Support registerSupport(Support support) {
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			// supportDao 사용
			// 등록
			support = supportDao.create(connection, support);
			// 상세조회
			support = supportDao.findByCode(connection, support.getQnacode());
			// 정상 처리 시 커밋
			connection.commit();
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return support;
	}

	@Override
	public List<Support> readSupport() {
		List<Support> list = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			list = supportDao.findByAll(connection);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return list;
	}
	
	// 테스트 메인
	public static void main(String[] args) {
//		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		
//		상품 관련 테스트------------------------------------------------------------------------------------------------------------------------------------------------------
//		ProductService productService = serviceFactory.getProductService();
//		Product product = null;
//		product = new Product("1", "작은 가방", 2300000, "작고 세련된 가방", "white", "보테가", "1", "testImage.png", "testImage1.png, testImage2.png, testImage3.png", 2);
//		product = new Product("2", "중간 가방", 5000000, "은근히 큰 가방", "yellow", "샤넬", "1", "testImage.png", "testImage1.png, testImage2.png, testImage3.png", 4);
//		product = new Product("3", "큰 가방", 6700000, "대용량 가방", "yellow", "프라다", "1", "testImage.png", "testImage1.png, testImage2.png, testImage3.png", 5);
//		product = new Product("4", "핸드백", 4800000, "손에 들고 다니기 좋은 가방", "brown", "샤넬", "1", "testImage.png", "testImage1.png, testImage2.png, testImage3.png", 1);
//		product = productService.registerProduct(product);
//		System.out.println("등록 후 상세정보 : " + product);
		
//		Product product = productService.readNumProduct("3");
//		System.out.println(product);
		
//		List<Product> list = productService.readProduct();
//		for (Product product : list) {
//			System.out.println(product);
//		}
		
//		문의 관련 테스트------------------------------------------------------------------------------------------------------------------------------------------------------
//		SupportService supportService = serviceFactory.getSupportService();
//		Support support = null;
//		support = new Support("2", "맘에 들어요", "깔끔하고 이쁘네요", "최재헌");
//		support = supportService.registerSupport(support);
//		System.out.println("등록 후 상세정보 : " + support);
		
//		List<Support> list = supportService.readSupport();
//		for (Support support2 : list) {
//			System.out.println(support2);
//		}
		
//		멤버 관련 테스트------------------------------------------------------------------------------------------------------------------------------------------------------
//		Member loginMember = memberService.isMember("bangry", "1111");
//		System.out.println(loginMember);
		
//		List<Member> members = memberService.getMembers();
//		System.out.println(members);
		
//		Member detailMember = memberService.readMember("bangry1");
//		System.out.println(detailMember);
		
	}

}
