package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoSer;
	
	@Autowired
	private ICursoService cursoSer;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	
	@GetMapping("/alumnos")
	public ModelAndView getAlumunosPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_alumnos");
		mav.addObject("alumnos", alumnoSer.getAlumnos());
		return mav;
	}
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		model.addAttribute("alumno", alumnoSer.getAlumno());
		model.addAttribute("cursos", cursoSer.getCursos());
		return "nuevo_alumno";
	}
	
	@PostMapping("/alumnos")
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			mav.addObject("cursos", cursoSer.getCursos());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:alumnos");
		if(alumnoSer.findByDni(alumno.getDni()) != null) {
			LOGGER.info("Ya existe un alumno con el DNI: "+alumno.getDni()+" registrado");
			return mav;
		}
		alumnoSer.saveAlumno(alumno);
		return mav;
	}
}