package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.model.Curso;

import ar.edu.unju.fi.util.ListaCurso;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	// creo un objeto de la clase ListaAlumno, donde está el arrayList
	ListaCurso listaCurso = new ListaCurso();
	@GetMapping("/nuevo")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo_curso";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCursoPage(@ModelAttribute("curso")Curso curso) {
		ModelAndView mav = new ModelAndView("lista_curso");
		
		//recupero el arrayList y agrego un objeto alumno a lista
		if(listaCurso.getCusrsos().add(curso)) {
			LOGGER.info("Se agregó un objeto al arrayList de curso");
		}
		//enviar el arrayList de alumnos a la página lista_alumnos
		mav.addObject("cursos", listaCurso.getCusrsos());
		return mav;
	}
}