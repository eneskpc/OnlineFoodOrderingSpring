package org.zerhusen.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.model.City;
import org.zerhusen.repository.CityRepository;

@CrossOrigin
@RestController
public class CityService {
	@Autowired
	CityRepository cityRepository;

	@RequestMapping(path = "/cities", method = RequestMethod.GET)
	public Iterable<City> getAllCities() {
		return cityRepository.findAll();
	}

	@RequestMapping(path = "/city-by-id/{id}", method = RequestMethod.GET)
	public Optional<City> getCity(@PathVariable("id") Long cityID) {
		return cityRepository.findById(cityID);
	}

	@RequestMapping(path = "/city-by-link/{link}", method = RequestMethod.GET)
	public City getCity(@PathVariable("link") String seoLink) {
		List<City> cities = cityRepository.findAll().stream().filter(c -> c.getSeoLink().equals(seoLink))
				.collect(Collectors.toList());
		if (cities.size() > 0)
			return cities.get(0);
		return null;
	}
}