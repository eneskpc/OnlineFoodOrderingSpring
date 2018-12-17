package org.zerhusen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_item_options")
public class ProductItemOption {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "option_name")
	private String optionName;
	@Column(name = "price_difference")
	private double priceDifference;
	@Column(name = "item_id")
	private Long productItemId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public double getPriceDifference() {
		return priceDifference;
	}

	public void setPriceDifference(double priceDifference) {
		this.priceDifference = priceDifference;
	}

	public Long getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Long productItemId) {
		this.productItemId = productItemId;
	}
}
