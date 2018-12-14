package org.zerhusen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.model.District;
import org.zerhusen.repository.DistrictRepository;

@CrossOrigin
@RestController
public class DistrictService {
	@Autowired
	DistrictRepository districtRepository;
	
	@RequestMapping(path = "/districts", method = RequestMethod.GET)
	public Iterable<District> getAllDistricts(){
		return districtRepository.findAll();
	}
}