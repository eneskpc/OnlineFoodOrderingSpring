package org.zerhusen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "districts")
public class District {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "district_name")
	private String districtName;
	
	@Column(name = "seo_link")
	private String seoLink;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id")
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getSeoLink() {
		return seoLink;
	}

	public void setSeoLink(String seoLink) {
		this.seoLink = seoLink;
	}
}
