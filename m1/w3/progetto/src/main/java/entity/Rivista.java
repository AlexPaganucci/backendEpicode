package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rivista extends CatalogoBibliotecario{
	
	private PeriodicitaRiviste periodicita;
}
