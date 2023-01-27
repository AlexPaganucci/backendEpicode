package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
public abstract class CatalogoBibliotecario {

	@Id
	@SequenceGenerator(name = "biblioteca_seq", sequenceName = "biblioteca_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biblioteca_seq")
	private Long id;
	private String codiceISBN;
	private String titolo;
	private int annoDiPubblicazione;
	private int numeroPagine;
}
