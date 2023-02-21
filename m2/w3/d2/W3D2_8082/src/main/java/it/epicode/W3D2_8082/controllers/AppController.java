package it.epicode.W3D2_8082.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.W3D2_8082.models.Gender;
import it.epicode.W3D2_8082.models.Persona;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/data1")
	public String response() {
		return "response";
	}
	
	@GetMapping("/data2")
	public List<Persona> persone(){
		return new ArrayList<Persona>() {{
			add(new Persona(1, "Mario Rossi", "MRossi", Gender.M));
			add(new Persona(2, "Luigi Verdi", "LVerdi", Gender.M));
			add(new Persona(3, "Anna Neri", "ANeri", Gender.F));
			add(new Persona(4, "Bianca Bianchi", "BBianchi", Gender.F));
		}};
	}
	
	@GetMapping("/data3")
	public List<Persona> persone2(){
		return new ArrayList<Persona>() {{
			add(new Persona(1, "Mario Rossi", "MRossi", Gender.M));
			add(new Persona(2, "Luigi Verdi", "LVerdi", Gender.M));
			add(new Persona(3, "Anna Neri", "ANeri", Gender.F));
			add(new Persona(4, "Bianca Bianchi", "BBianchi", Gender.F));
		}};
	}

}
