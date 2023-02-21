package it.epicode.W3D2_8082.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

	private int id;
	private String fullname;
	private String username;
	private Gender gender;
}
