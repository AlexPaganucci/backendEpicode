package entity;

import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "autori")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Autore {

	@Id
	@SequenceGenerator(name = "autore_seq", sequenceName = "autore_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autore_seq")
	private Long id;
	private String name;
	@OneToMany(mappedBy = "autore", cascade = CascadeType.REMOVE)
	private Set<Libro> libri;
}
