package entity.eventi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import entity.Evento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "partita_di_calcio")
@Setter
@Getter
@ToString
public class PartitaDiCalcio extends Evento{
	@Column(name = "squadra_di_casa")
	private String squadraDiCasa;
	@Column(name = "squadra_ospite")
	private String squadraOspite;
	@Column(name = "squadra_vincente")
	private String squadraVincente;
	@Column(name = "numero_gol_squadra_di_casa")
	private int numeroGolSquadraDiCasa;
	@Column(name = "numero_gol_squadra_ospite")
	private int numeroGolSquadraOspite;

}
