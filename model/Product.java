package model;

public class Product {
	private String productId;
	private String productName;
	private String productPrice;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId= productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public Product(String productId, String productName, String productPrice) {
		super();
		this.productId= productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public Product() {};
	

}
