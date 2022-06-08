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

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	// creo un objeto de la clase ListaDocente, donde está el arrayList
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
	public ModelAndView getListaDocentesPage(@ModelAttribute("docente")Docente docente) {
		ModelAndView mav = new ModelAndView("lista_docentes");
		
		//recupero el arrayList y agrego un objeto docente a lista
		if(listaDocentes.getDocentes().add(docente)) {
			LOGGER.info("Se agregó un nuevo docente al arrayList de docentes");
		}
		//enviar el arrayList de docentes a la página lista_docentes
		mav.addObject("docentes", listaDocentes.getDocentes());
		return mav;
	}
	
	
}
