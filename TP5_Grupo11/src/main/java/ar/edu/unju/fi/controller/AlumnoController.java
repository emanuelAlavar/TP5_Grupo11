package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	// creo un objeto de la clase ListaAlumno, donde estÃ¡ el arrayList
	ListaAlumno listaAlumnos = new ListaAlumno();
	
	@GetMapping("/alumnos")
	public ModelAndView getAlumunosPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_alumnos");
		mav.addObject("alumnos", listaAlumnos.getAlumnos());
		return mav;
	}
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}
	
	@PostMapping("/alumnos")
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validaciÃ³n");
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_alumnos");
		
		if(listaAlumnos.getAlumnos().add(alumno)) {
			LOGGER.info("Se agregÃ³ un nuevo alumno al arrayList de alumnos");
		}
		mav.addObject("alumnos", listaAlumnos.getAlumnos());
		return mav;
	}
}