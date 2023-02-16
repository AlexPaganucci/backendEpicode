package it.epicode.be.bookingmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.bookingmanagement.models.User;
import it.epicode.be.bookingmanagement.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userSrv;
	
	@GetMapping("/")
	public String index() {
		return "USER HOME";
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userSrv.getAllUsers();
		if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	private ResponseEntity<User> checkExists(Optional<User> u) {
		if (!u.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else return null;
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User x) {		
	    Optional<User> cOpt = userSrv.getUserById(id);		
	    ResponseEntity<User> check = checkExists(cOpt);
	    if (check != null) {
	        return check;
	    }
	    User b = cOpt.get();
	    b.setUsername(x.getUsername());
	    b.setFullname(x.getFullname());
	    b.setEmail(x.getEmail());
	    userSrv.save(b);		
	    return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
	    User savedUser = userSrv.saveUser(newUser);
	    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
}
