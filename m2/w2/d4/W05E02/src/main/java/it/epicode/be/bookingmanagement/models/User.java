package it.epicode.be.bookingmanagement.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String fullname;
	private String password;
	private String email;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Booking> bookings;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	
	@Override
	public String toString() {
		return "Id: " + String.format("%1$-"+ 5 + "s", this.getId()) + "Full Name: " + String.format("%1$-"+ 18 + "s",this.getFullname()) 
			 + "UserName: " + String.format("%1$-"+ 13 + "s", this.getUsername()) + "Email: " + String.format("%1$-"+ 25 + "s", this.getEmail());
	}
}
