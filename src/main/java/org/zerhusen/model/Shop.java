package org.zerhusen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.zerhusen.model.security.User;

@Entity
@Table(name = "shops")
public class Shop {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "seo_link")
	private String seoLink;

	@Column(name = "min_price")
	private double minPrice;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "shop_responsibles", joinColumns = {
			@JoinColumn(name = "shop_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private List<User> users;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "shop_districts", joinColumns = {
			@JoinColumn(name = "shop_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "district_id", referencedColumnName = "id") })
	private List<District> districts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public String getSeoLink() {
		return seoLink;
	}

	public void setSeoLink(String seoLink) {
		this.seoLink = seoLink;
	}
}
