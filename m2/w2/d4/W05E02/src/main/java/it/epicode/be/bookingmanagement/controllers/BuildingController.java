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
import it.epicode.be.bookingmanagement.models.Building;
import it.epicode.be.bookingmanagement.services.BuildingService;

@RestController
@RequestMapping("/api")
public class BuildingController {
	
	@Autowired
	private BuildingService bS;

	@GetMapping("buildings")
	public ResponseEntity<Object> getAllbuildings(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2000") int size) {
		Pageable p = PageRequest.of(page, size);
		Page<Building> buildings = bS.getAllBuildings(p);		
		if (buildings.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);				
		else return new ResponseEntity<>(buildings, HttpStatus.OK);
	}
	
	@GetMapping("buildings/{id}")
	public ResponseEntity<Building> getById(@PathVariable Long id) {
		Optional<Building> Building = bS.getBuildingById(id);
		ResponseEntity<Building> check = checkExists(Building);
		if (check != null) return check;		
		else return new ResponseEntity<>(Building.get(), HttpStatus.OK);
	}
	
	@PostMapping("buildings")
	public ResponseEntity<Object> create(@RequestBody Building x) {
		bS.save(x);
		Building c = bS.getBuildingByName(x.getName()).get(0);		
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@PutMapping("buildings/{id}")
	public ResponseEntity<Building> update(@PathVariable Long id, @RequestBody Building x) {		
		Optional<Building> cOpt = bS.getBuildingById(id);		
		ResponseEntity<Building> check = checkExists(cOpt);
		if( check != null ) return check;		
		Building b = cOpt.get();
		b.setName(x.getName());
		b.setAddress(x.getAddress());
		b.setCity(x.getCity());
		bS.save(b);		
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
	
	@DeleteMapping("buildings/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Optional<Building> cOpt = bS.getBuildingById(id);
		if( cOpt.isPresent()) {
			bS.deleteBuildingById(id);
			return new ResponseEntity<>(String.format("The Building with id %d has been deleted!", id), HttpStatus.OK);
		} else return new ResponseEntity<>(String.format("The Building with id %d was not found!", id),HttpStatus.NOT_FOUND);
	}
	
	private ResponseEntity<Building> checkExists(Optional<Building> b) {
		if (!b.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else return null;
	}
}

