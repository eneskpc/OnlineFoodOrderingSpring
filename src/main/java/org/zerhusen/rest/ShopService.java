package org.zerhusen.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.model.Shop;
import org.zerhusen.model.security.User;
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

	@RequestMapping(value = "shops")
	public List<Shop> getAllShops() {
		return shopRepository.findAll();
	}
}
