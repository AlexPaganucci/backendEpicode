package it.epicode.be.bookingmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.bookingmanagement.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
