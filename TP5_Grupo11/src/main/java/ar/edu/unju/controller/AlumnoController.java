package ar.edu.unju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class AlumnoController {

	@GetMapping("/alumno")
	public String getDocentePage() {
		return "Alumno";
	}
}
