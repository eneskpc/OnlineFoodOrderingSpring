package org.zerhusen.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.AddressDTO;
import org.zerhusen.model.Address;
import org.zerhusen.model.District;
import org.zerhusen.model.security.User;
import org.zerhusen.repository.AddressRepository;
import org.zerhusen.repository.DistrictRepository;
import org.zerhusen.security.JwtTokenUtil;
import org.zerhusen.security.repository.UserRepository;

@RestController
@CrossOrigin
public class AddressService {
	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(path = "/addresses", method = RequestMethod.GET)
	public Iterable<Address> getAllAddresses(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader).substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User currentUser = userRepository.findByUsername(username);

		List<Address> userAddresses = addressRepository.findAll().stream().filter(a -> a.getUser().equals(currentUser))
				.collect(Collectors.toList());

		return userAddresses;
	}

	@RequestMapping(path = "/address", method = RequestMethod.POST)
	public boolean setAddress(HttpServletRequest request, @RequestBody AddressDTO newAddressDTO) {
		String token = request.getHeader(tokenHeader).substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User currentUser = userRepository.findByUsername(username);
		
		System.out.println(newAddressDTO.fullAddress);
		System.out.println(newAddressDTO.title);
		System.out.println(newAddressDTO.districtID);
		
		Address newAddress = new Address();
		newAddress.setFullAddress(newAddressDTO.fullAddress);
		newAddress.setTitle(newAddressDTO.title);
		
		District receivedDistrict = districtRepository.findById(newAddressDTO.districtID).get();
		newAddress.setDistrict(receivedDistrict);
		newAddress.setUser(currentUser);
		
		if (addressRepository.save(newAddress) != null)
			return true;
		return false;
	}

}