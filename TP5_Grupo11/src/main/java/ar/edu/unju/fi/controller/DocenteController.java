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

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	// creo un objeto de la clase ListaDocente, donde estÃ¡ el arrayList
	ListaDocente listaDocentes = new ListaDocente();
	
	
	@GetMapping("/docentes")
	public ModelAndView getDocentesPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("docentes", listaDocentes.getDocentes());
		return mav;
	}
	
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnnoPage(Model model) {
		model.addAttribute("docente", new Docente());
		return "nuevo_docente";
	}

	
	@PostMapping("/docentes")
	public ModelAndView getListaDocentesPage(@Validated @ModelAttribute("docente")Docente docente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validaciÃ³n");
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_docentes");
		
		//recupero el arrayList y agrego un objeto docente a lista
		if(listaDocentes.getDocentes().add(docente)) {
			LOGGER.info("Se agrego un nuevo docente al arrayList de docentes");
		}
		//enviar el arrayList de docentes a la pÃ¡gina lista_docentes
		mav.addObject("docentes", listaDocentes.getDocentes());
		return mav;
	}
	
	
}
