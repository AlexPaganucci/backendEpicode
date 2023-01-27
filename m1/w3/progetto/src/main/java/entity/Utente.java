package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

	@Id
	@SequenceGenerator(name = "utente_seq", sequenceName = "utente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_seq")
	private Long id;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private int numeroDiTessera;
	@OneToMany(mappedBy = "utente")
	private Set<Prestito> prestiti;
}
