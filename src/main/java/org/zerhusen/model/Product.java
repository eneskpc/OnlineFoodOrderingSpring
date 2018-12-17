package org.zerhusen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "description")
	private String description;

	@Column(name = "is_stock")
	private boolean isStock;

	@Column(name = "unit_price")
	private double unitPrice;

	@OneToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private List<ProductItem> productItems;

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isStock() {
		return isStock;
	}

	public void setStock(boolean isStock) {
		this.isStock = isStock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
