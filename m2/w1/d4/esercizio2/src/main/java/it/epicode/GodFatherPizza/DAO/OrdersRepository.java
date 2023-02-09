package it.epicode.GodFatherPizza.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.GodFatherPizza.beans.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
