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

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private IDocenteService docenteSer;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);

	
	
	@GetMapping("/docentes")
	public ModelAndView getDocentesPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("docentes", docenteSer.getDocentes());
		return mav;
	}
	
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnnoPage(Model model) {
		model.addAttribute("docente", docenteSer.getDocente());
		return "nuevo_docente";
	}

	
	@PostMapping("/docentes")
	public ModelAndView getListaDocentesPage(@Validated @ModelAttribute("docente")Docente docente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:docentes");
		if(docenteSer.findByDni(docente.getDni()) != null) {
			LOGGER.info("Ya existe un alumno con el DNI: "+docente.getDni()+" registrado");
			return mav;
		}
		docenteSer.saveDocente(docente);
		return mav;
	}
	
	
}
