package getbag.shopping.domain.product.dto;

/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * @author 홍재헌
 *
 */
public class Product {
	
	private String catecode;
	private String proname;
	private String proprice;
	private String prosale;
	private String proinfo;
	private String proqty;
	private String prothumb;
	private String proimg;
	
	public Product() {}

	public Product(String catecode, String proname, String proprice, String prosale, String proinfo, String proqty, String prothumb, String proimg) {
		super();
		this.catecode = catecode;
		this.proname = proname;
		this.proprice = proprice;
		this.prosale = prosale;
		this.proinfo = proinfo;
		this.proqty = proqty;
		this.prothumb = prothumb;
		this.proimg = proimg;
	}
	
	public String getCatecode() {
		return catecode;
	}

	public void setCatecode(String catecode) {
		this.catecode = catecode;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProprice() {
		return proprice;
	}

	public void setProprice(String proprice) {
		this.proprice = proprice;
	}

	public String getProsale() {
		return prosale;
	}

	public void setProsale(String prosale) {
		this.prosale = prosale;
	}

	public String getProinfo() {
		return proinfo;
	}

	public void setProinfo(String proinfo) {
		this.proinfo = proinfo;
	}

	public String getProqty() {
		return proqty;
	}

	public void setProqty(String proqty) {
		this.proqty = proqty;
	}

	public String getProthumb() {
		return prothumb;
	}

	public void setProthumb(String prothumb) {
		this.prothumb = prothumb;
	}

	public String getProimg() {
		return proimg;
	}

	public void setProimg(String proimg) {
		this.proimg = proimg;
	}

	@Override
	public String toString() {
		return "Product [catecode=" + catecode + ", proname=" + proname + ", proprice=" + proprice + ", prosale="
				+ prosale + ", proinfo=" + proinfo + ", proqty=" + proqty + ", prothumb=" + prothumb + ", proimg="
				+ proimg + "]";
	}

}













