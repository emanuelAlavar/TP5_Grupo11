package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Alumno;



@Controller
@RequestMapping("/inicio")
public class AlumnoController {

	@GetMapping("/alumno")
	public String getIndexPage(Model model) {
		Alumno unAlumno = new Alumno(333333,"Hector","Cruz","hector@gmail.com",444);
		model.addAttribute("alumno",unAlumno);		
		return "Alumno";
	}
}