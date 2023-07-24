package getbag.shopping.domain.product.service;

import java.util.List;

import getbag.shopping.domain.product.dto.Product;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리를 위한 명세
 * @author 홍재헌
 */
public interface ProductService {
	/** 회원 등록 */
	public Product registerProduct(Product product);
	/** 회원 인증 */
	public Product isMember(String id, String passwd);
	/** 회원 전체 목록 */
	public List<Product> getProducts();
	/** 회원 상세정보 조회 */
	public Product readProduct(String id);
}
