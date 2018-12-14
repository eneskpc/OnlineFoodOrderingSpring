package org.zerhusen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
	@SequenceGenerator(name = "city_seq", sequenceName = "city_seq", allocationSize = 1)
	private Long id;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "seo_link", unique = true)
	private String seoLink;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getSeoLink() {
		return seoLink;
	}

	public void setSeoLink(String seoLink) {
		this.seoLink = seoLink;
	}

}
