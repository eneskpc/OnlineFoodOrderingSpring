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
import javax.persistence.Table;

@Entity
@Table(name = "product_items")
public class ProductItem {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_type")
	private String itemType;
	
	@Column(name = "product_id")
	private Long productId;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private List<ProductItemOption> productItemOptions;

	public Long getId() {
		return id;
	}

	public List<ProductItemOption> getProductItemOptions() {
		return productItemOptions;
	}

	public void setProductItemOptions(List<ProductItemOption> productItemOptions) {
		this.productItemOptions = productItemOptions;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long product_id) {
		this.productId = product_id;
	}
}
