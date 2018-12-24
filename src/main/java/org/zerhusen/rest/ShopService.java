package org.zerhusen.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.model.District;
import org.zerhusen.model.Shop;
import org.zerhusen.model.security.User;
import org.zerhusen.repository.DistrictRepository;
import org.zerhusen.repository.ShopRepository;
import org.zerhusen.security.JwtTokenUtil;
import org.zerhusen.security.repository.UserRepository;

@CrossOrigin
@RestController
public class ShopService {
	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "userShop")
	public Shop getAuthenticatedUserShop(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader).substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User currentUser = userRepository.findByUsername(username);

		List<Shop> shops = shopRepository.findAll().stream().filter(s -> s.getUsers().contains(currentUser))
				.collect(Collectors.toList());
		if (shops.size() > 0)
			return shops.get(0);
		return null;
	}

	@RequestMapping(value = "currentShopWithId/{id}")
	public Optional<Shop> getShopWithId(@PathVariable Long id) {
		return shopRepository.findById(id);
	}
	
	@RequestMapping(value = "currentShopWithLink/{link}")
	public Shop getShopWithLink(@PathVariable String link) {
		List<Shop> allShops = shopRepository.findAll();
		return allShops.stream().filter(s->s.getSeoLink().equals(link)).collect(Collectors.toList()).get(0);
	}

	@RequestMapping(value = "shops/{districtSeo}")
	public List<Shop> getAllShops(@PathVariable String districtSeo) {
		District currentDistrict = districtRepository.findAll().stream().filter(d -> d.getSeoLink().equals(districtSeo))
				.collect(Collectors.toList()).get(0);

		return shopRepository.findAll().stream().filter(s -> s.getDistricts().contains(currentDistrict))
				.collect(Collectors.toList());
	}
}
