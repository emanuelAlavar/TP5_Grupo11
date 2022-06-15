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

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.util.ListaCurso;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	// creo un objeto de la clase ListaAlumno, donde está el arrayList
	ListaCurso listaCurso = new ListaCurso();
	
	@GetMapping("/cursos")
	public ModelAndView getDocentesPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_curso");
		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo_curso";
	}
	
	@PostMapping("/cursos")
	public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_curso");
		

		if(listaCurso.getCursos().add(curso)) {
			LOGGER.info("Se agregó un nuevo curso al arrayList de curso");
		}

		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
}