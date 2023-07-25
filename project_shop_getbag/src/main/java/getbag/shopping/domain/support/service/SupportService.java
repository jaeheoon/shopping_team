package getbag.shopping.domain.support.service;

import java.util.List;

import getbag.shopping.domain.support.dto.Support;

/**
 * 문의글 관련 비즈니스 로직 처리 및 트랜잭션 관리를 위한 명세
 * @author 홍재헌
 */
public interface SupportService {
	/** 문의 등록 */
	public Support registerSupport(Support support);
	/** 문의 전체 조회 */
	public List<Support> readSupport();
}
