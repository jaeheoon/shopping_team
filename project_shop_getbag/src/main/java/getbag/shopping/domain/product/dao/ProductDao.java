package getbag.shopping.domain.product.dao;

import java.sql.Connection;
import java.util.List;

import getbag.shopping.domain.product.dto.Product;

/**
 * 데이터 베이스 회원 관리 명세
 *  @author 홍재헌
 *
 */
public interface ProductDao {
	
	public boolean create(Connection connection, Product product);
	public Product findByName(Connection connection, String proname);
	public List<Product> findByAll(Connection connection);
	public Product findByNum(Connection connection, String catecode);
}
