package getbag.shopping.domain.product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import getbag.shopping.domain.common.factory.ServiceFactory;
import getbag.shopping.domain.member.dao.MemberDao;
import getbag.shopping.domain.member.dto.Member;
import getbag.shopping.domain.product.dao.ProductDao;
import getbag.shopping.domain.product.dto.Product;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
public class ProductServiceImpl implements ProductService{
	
	private DataSource dataSource;
	private ProductDao productDao;
	
	public ProductServiceImpl(DataSource dataSource, ProductDao productDao) {
		this.dataSource = dataSource;
		this.productDao = productDao;
	}

	@Override
	public Product registerProduct(Product product) {
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			// memberDao 사용
			// 등록
//			memberDao.create(connection, product);
			// 상세조회
//			product = memberDao.findById(connection, product.getId());
			// 정상 처리 시 커밋
			connection.commit();
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return null;
	}

	@Override
	public Product isMember(String id, String passwd) {
		Member member = null;
		Connection connection = null;
		try {
			// select는 트랜잭션 X
			connection = dataSource.getConnection();
//			member = productDao.findByUser(connection, id, passwd);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return null;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			products = productDao.findByAll(connection);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return products;
	}

	@Override
	public Product readProduct(String id) {
		Member member = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
//			member = memberDao.findById(connection, id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return null;
	}
	
	// 테스트 메인
	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		
		Product product= new Product("1", "미니 가방", "5000000", "4800000", "작고 세련된 작은 가방", "150", "testImage1.png", "testImage1.png,testImage2.png,testImage3.png");
		product = productService.registerProduct(product);
		System.out.println("등록 후 상세정보 : " + product);
		
//		Member loginMember = memberService.isMember("bangry", "1111");
//		System.out.println(loginMember);
		
//		List<Member> members = memberService.getMembers();
//		System.out.println(members);
		
//		Member detailMember = memberService.readMember("bangry1");
//		System.out.println(detailMember);
		
	}

}
