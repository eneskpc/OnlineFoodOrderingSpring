package org.zerhusen.rest;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.model.security.User;
import org.zerhusen.security.repository.UserRepository;

@CrossOrigin
@RestController
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public Iterable<User> getAllUsers() {
		return userRepository.findAll().stream().filter(u -> u.getEnabled()).collect(Collectors.toList());
	}
}
