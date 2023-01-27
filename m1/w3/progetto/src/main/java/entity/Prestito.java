package entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "prestiti")
@NoArgsConstructor
@AllArgsConstructor
public class Prestito {

	@Id
	@SequenceGenerator(name = "prestito_seq", sequenceName = "prestito_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestito_seq")
	private Long id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	@JoinColumn(name = "catalogo_id")
	private CatalogoBibliotecario elementoPrestato;
	private Date dataInizioPrestito;
	private Date dataRestituzionePrevista;
	private Date dataRestituzioneEffettiva;
	
	public void setDataRestituzionePrevista(Date dataInizioPrestito) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataInizioPrestito);
		cal.add(Calendar.DATE, 30);
		this.dataRestituzionePrevista = cal.getTime();
	}
	
	public Date getDataRestituzionePrevista() {
		return this.dataRestituzionePrevista;
	}
}
