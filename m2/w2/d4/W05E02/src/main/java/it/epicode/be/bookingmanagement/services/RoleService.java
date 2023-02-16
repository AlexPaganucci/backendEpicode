package it.epicode.be.bookingmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.bookingmanagement.models.Role;
import it.epicode.be.bookingmanagement.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public Role saveRole(Role r) {
		return roleRepo.save(r);
	}
}
