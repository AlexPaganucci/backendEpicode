package it.epicode.be.prenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.model.User;
import it.epicode.be.prenotazioni.repository.UserRepository;

@Service
public class UtenteService {

	@Autowired
	private UserRepository userRepo;
	
	public User save(User u) {
		return userRepo.save(u);
	}
	
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	public Optional<User> getById(Long id){
		return userRepo.findById(id);
	}
	
    public boolean deleteById(Long id) {
        userRepo.deleteById(id);
        return true;
    }
}
