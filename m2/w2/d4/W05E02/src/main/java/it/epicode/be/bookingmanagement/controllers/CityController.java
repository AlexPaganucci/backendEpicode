package it.epicode.be.bookingmanagement.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.epicode.be.bookingmanagement.models.City;
import it.epicode.be.bookingmanagement.services.CityService;

@RestController
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	private CityService cS;
	
	@GetMapping("")
	public String index() {
		return "API HOME";
	}

	@GetMapping("cities")
	public ResponseEntity<Object> getAllCities(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2000") int size) {
		Pageable p = PageRequest.of(page, size);
		Page<City> cities = cS.getAllCities(p);		
		if (cities.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);				
		else return new ResponseEntity<>(cities, HttpStatus.OK);
	}
	
	@GetMapping("cities/{id}")
	public ResponseEntity<City> getById(@PathVariable Long id) {
		Optional<City> city = cS.getCityById(id);
		ResponseEntity<City> check = checkExists(city);
		if (check != null) return check;		
		else return new ResponseEntity<>(city.get(), HttpStatus.OK);
	}
	
	@PostMapping("cities")
	public ResponseEntity<Object> create(@RequestBody City x) {
		cS.save(x);
		City c = cS.getCityByName(x.getName()).get(0);		
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@PutMapping("cities/{id}")
	public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City x) {		
		Optional<City> cOpt = cS.getCityById(id);		
		ResponseEntity<City> check = checkExists(cOpt);
		if( check != null ) return check;		
		City c = cOpt.get();
		c.setName(x.getName());
		cS.save(c);		
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@DeleteMapping("cities/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Optional<City> cOpt = cS.getCityById(id);
		if( cOpt.isPresent()) {
			cS.deleteCityById(id);
			return new ResponseEntity<Object>(String.format("The City with id %d has been deleted!", id), HttpStatus.OK);
		} else return new ResponseEntity<Object>(String.format("The City with id %d was not found!", id), HttpStatus.NOT_FOUND);
	}
	
	private ResponseEntity<City> checkExists(Optional<City> c) {
		if (!c.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else return null;
	}
}
