package getbag.shopping.domain.product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import getbag.shopping.domain.common.factory.ServiceFactory;
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
			// productDao 사용
			// 등록
			productDao.create(connection, product);
			// 상세조회
			product = productDao.findByName(connection, product.getPname());
			// 정상 처리 시 커밋
			connection.commit();
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return product;
	}

	@Override
	public Product readNameProduct(String name) {
		Product product = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			product = productDao.findByName(connection, name);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return product;
	}
	
	@Override
	public Product readNumProduct(String code) {
		Product product = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			product = productDao.findByNum(connection, code);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return product;
	}
	
	@Override
	public List<Product> readProduct() {
		List<Product> list = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			list = productDao.findByAll(connection);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return list;
	}
	
	// 테스트 메인
	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
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
		
//		Member loginMember = memberService.isMember("bangry", "1111");
//		System.out.println(loginMember);
		
//		List<Member> members = memberService.getMembers();
//		System.out.println(members);
		
//		Member detailMember = memberService.readMember("bangry1");
//		System.out.println(detailMember);
		
	}

}
