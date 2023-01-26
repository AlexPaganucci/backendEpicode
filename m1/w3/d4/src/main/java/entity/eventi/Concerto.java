package entity.eventi;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import entity.Evento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "concerto")
@Setter
@Getter
@ToString
public class Concerto extends Evento{

	@Enumerated(EnumType.STRING)
	private Genere genere;
	private boolean inStreaming;
}
