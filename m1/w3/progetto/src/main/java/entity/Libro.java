package entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "libri")
@NoArgsConstructor
@AllArgsConstructor
public class Libro extends CatalogoBibliotecario{
	
	@ManyToOne
	@JoinColumn(name = "autori_id")
	private Autore autore;
	private GenereLibro genere;
}
