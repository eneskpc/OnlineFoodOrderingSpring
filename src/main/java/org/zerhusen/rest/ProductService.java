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
import org.zerhusen.model.Product;
import org.zerhusen.model.Shop;
import org.zerhusen.repository.ProductRepository;
import org.zerhusen.repository.ShopRepository;

@CrossOrigin
@RestController
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ShopRepository shopRepository;

	@RequestMapping(path = "/products/{shopSeo}", method = RequestMethod.GET)
	public Iterable<Product> getProductByShopLink(@PathVariable String shopSeo) {
		List<Shop> shops = shopRepository.findAll().stream().filter(s -> s.getSeoLink().equals(shopSeo))
				.collect(Collectors.toList());
		Shop currentShop = shops.get(0);
		return productRepository.findAll().stream().filter(p -> p.getShop().equals(currentShop))
				.collect(Collectors.toList());
	}

	@RequestMapping(path = "/product/{id}", method = RequestMethod.GET)
	public Optional<Product> getProductByShopLink(@PathVariable Long id) {
		return productRepository.findById(id);
	}
}
