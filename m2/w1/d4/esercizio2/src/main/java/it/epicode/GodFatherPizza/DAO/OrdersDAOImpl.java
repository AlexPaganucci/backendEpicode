package it.epicode.GodFatherPizza.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.GodFatherPizza.beans.Orders;
import it.epicode.GodFatherPizza.beans.enums.StatoOrdine;

@Service
public class OrdersDAOImpl {

	@Autowired
	private OrdersRepository ordersRepo;
	
	public List<Orders> getAll() {
		return ordersRepo.findAll();
	}
	
	public Optional<Orders> getById(int id) {
		return ordersRepo.findById(id);
	}
	
	public void insert(Orders o) {
		ordersRepo.save(o);
	}
	
	public void update(int id, StatoOrdine stato) {
		Optional<Orders> ordersOpt = this.getById(id);
		if( ordersOpt.isPresent() ) {
			Orders p = ordersOpt.get();
			p.setState(stato);
			
			ordersRepo.save(p);
			System.out.println("Lo stato è stato aggiornato");
		}
		else {
			System.out.println("Lo stato dell'ordine non è stato trovato con id #" + id);
		}
	}
}
